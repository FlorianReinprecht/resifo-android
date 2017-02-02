package at.fh.swengb.resifo_android

import android.content.{ContentValues, Context}
import android.database.Cursor
import android.database.sqlite.{SQLiteDatabase, SQLiteOpenHelper}

import scala.collection.mutable.ListBuffer


object ResDb {

  val Name = "mydb"
}

/**
  * A simple wrapper around SQLiteOpenHelper to ease SQLite access.
  *
  * Created by lad on 19/01/2017.
  */
case class ResDb(context: Context) extends SQLiteOpenHelper(context, ResDb.Name, null, 1) {

  override def onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int): Unit = ()

  override def onCreate(db: SQLiteDatabase): Unit = {

    // perform initial setup
    val personTable = RegFormTable(db)

    personTable.init()

  }

  def mkRegFormTable(): RegFormTable = RegFormTable(getWritableDatabase)

  /**
    * Hides details of database table 'Person'
    *
    * @param db
    */
  case class RegFormTable(db: SQLiteDatabase) {

    def init(): Unit = db.execSQL("create table regForm " +
      "(id INTEGER PRIMARY KEY ASC, anrede TEXT, firstname TEXT, secondname TEXT, gebDatum TEXT, gebOrt TEXT, famstand TEXT, staat TEXT, zmr INTEGER," +
      "art TEXT, ausstDatum TEXT, auszuBHD TEXT, an_strasse TEXT,an_hausNr TEXT, an_stiege TEXT, an_tuerNr TEXT," +
      "an_plz TEXT, an_ort TEXT, an_hauptWS INTEGER, ab_strasse TEXT, ab_hausNr TEXT, ab_stiege TEXT, ab_tuerNr TEXT," +
      "ab_plz TEXT, ab_ort TEXT, ausland INTEGER, korrekt INTEGER,unter_name STRING,unter_datum TEXT);")



    /**
      * Insert a person to the database.
      *
      * @param r
      */
    def insert(r: RegForm): Unit = {
      val cv: ContentValues = mkContentValues(r)
      db.insert("regForm", null, cv)
    }

    def deleteByFirstName(firstName : String) : Unit = {
      db.delete("regForm", "firstname = ?", Array(firstName))
    }

    def update(r : RegForm) : Unit = {
      db.update("regForm", mkContentValues(r), "firstname = ? and secondname = ?", Array(r.person.firstName,r.person.secondName))
    }

    /**
      * Returns a list of persons matching given firstName, or Nil if there is none
      *
      * @param firstName the firstName to search for
      * @return
      */
    def listByFirstName(firstName: String): List[RegForm] = {
      var someCursor: Option[Cursor] = None
      try {
        someCursor = someCursorForFirstnameQuery(firstName)
        someCursor match {
          case None =>
            System.err.println("Could not execute query due to some reason")
            Nil
          case Some(c) =>
            val lb = new ListBuffer[RegForm]()
            while (c.moveToNext()) {
              val id = c.getInt(c.getColumnIndex("id"))
              val anrede = c.getString(c.getColumnIndex("anrede"))
              val firstName = c.getString(c.getColumnIndex("firstname"))
              val secondName = c.getString(c.getColumnIndex("secondname"))
              val gebDatum = c.getString(c.getColumnIndex("gebDatum"))
              val gebOrt = c.getString(c.getColumnIndex("gebOrt"))
              val famStand = c.getString(c.getColumnIndex("famstand"))
              val staat = c.getString(c.getColumnIndex("staat"))
//              lb.append(RegForm(Person(anrede, firstName, secondName, gebDatum, gebOrt, famStand, staat)))
            }
            lb.toList
        }
      } finally {
        someCursor foreach (_.close())
      }

    }

    /**
      * Returns an optional cursor for a firstname query on the person table.
      *
      * @param firstName
      * @return
      */
    def someCursorForFirstnameQuery(firstName: String): Option[Cursor] = {
      Option(db.query("RegForm", Array("id", "anrede", "firstname", "secondname", "gebDatum","gebOrt","famstand","staat"), "firstname = ?", Array(firstName), null, null, null))
    }

    def somePersonCursor(): Option[Cursor] = {
      Option(db.query("RegForm", Array("id", "anrede", "firstname", "secondname","gebDatum","gebOrt","famstand","staat"), null, null, null, null, null))
    }


  }

  def mkContentValues(r: RegForm): ContentValues = {
    val cv = new ContentValues
    cv.put("anrede", r.person.anrede)
    cv.put("firstname", r.person.firstName)
    cv.put("secondname", r.person.secondName)
    cv.put("gebDatum", r.person.gebDatum)
    cv.put("gebOrt", r.person.gebOrt)
    cv.put("famstand", r.person.famStand)
    cv.put("staat", r.person.staat)

    cv
  }
}