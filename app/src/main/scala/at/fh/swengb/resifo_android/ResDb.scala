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
      "(id INTEGER PRIMARY KEY ASC, anrede TEXT, titel TEXT, firstname TEXT, secondname TEXT, famnameVor TEXT, gebDatum TEXT, gebOrt TEXT, famstand TEXT, religion TEXT, staat TEXT, zmr INTEGER," +
      "art TEXT, rdNr TEXT, ausstDatum TEXT, auszuBHD TEXT, an_strasse TEXT,an_hausNr TEXT, an_stiege TEXT, an_tuerNr TEXT," +
      "an_plz TEXT, an_ort TEXT, ab_strasse TEXT, ab_hausNr TEXT, ab_stiege TEXT, ab_tuerNr TEXT," +
      "ab_plz TEXT, ab_ort TEXT,unter_secondname TEXT, unter_firstname TEXT, unter_datum TEXT);")



    /**
      * Insert a person to the database.
      *
      * @param r
      */
    def insert(r: RegForm): Unit = {
      val cv: ContentValues = mkContentValues(r)
      db.insert("regForm", null, cv)
    }

    def deleteById(id : String) : Unit = {
      db.delete("regForm", "id = ?", null)
    }

    def update(r : RegForm) : Unit = {
      db.update("regForm", mkContentValues(r), "id = ?",null)
    }

    def listAll(): List[RegForm] = {
      var cursorRegForm: Option[Cursor] = None
      try {
        cursorRegForm = regFormCursor()
        cursorRegForm match {
          case None =>
            System.err.println("Could not execute query due to some reason")
            Nil
          case Some(c) =>
            val lb = new ListBuffer[RegForm]()
            while (c.moveToNext()) {
              val id = c.getInt(c.getColumnIndex("id"))
              val anrede = c.getString(c.getColumnIndex("anrede"))
              val titel = c.getString(c.getColumnIndex("titel"))
              val firstName = c.getString(c.getColumnIndex("firstname"))
              val secondName = c.getString(c.getColumnIndex("secondname"))
              val famnameVor = c.getString(c.getColumnIndex("famnameVor"))
              val gebDatum = c.getString(c.getColumnIndex("gebDatum"))
              val gebOrt = c.getString(c.getColumnIndex("gebOrt"))
              val famStand = c.getString(c.getColumnIndex("famstand"))
              val religion = c.getString(c.getColumnIndex("religion"))
              val staat = c.getString(c.getColumnIndex("staat"))
              lb.append(RegForm(Person(anrede, titel, firstName, secondName, famnameVor, gebDatum, gebOrt, famStand,religion, staat),Zmr(""), Reisepass("", "", "",""), AnmUnterkunft("", "", "", "", "", "", ""), HauptwohnsitzBleibt("", "", "", "", "", "", ""), AbmUnterkunft("", "", "", "", "","", ""),Unterkunftgeber("", "","")))
            }
            lb.toList
        }
      } finally {
        cursorRegForm foreach (_.close())
      }

    }


    def regFormCursor(): Option[Cursor] = {
      Option(db.query("RegForm", Array("id", "anrede","titel", "firstname", "secondname", "famnameVor", "gebDatum","gebOrt","famstand","religion","staat"), null, null, null, null, null))
    }


  }

  def mkContentValues(r: RegForm): ContentValues = {
    val cv = new ContentValues
    cv.put("anrede", r.person.anrede)
    cv.put("firstname", r.person.firstName)
    cv.put("titel", r.person.titel)
    cv.put("secondname", r.person.secondName)
    cv.put("famnameVor", r.person.famnameVor)
    cv.put("gebDatum", r.person.gebDatum)
    cv.put("gebOrt", r.person.gebOrt)
    cv.put("famstand", r.person.famStand)
    cv.put("religion", r.person.religion)
    cv.put("staat", r.person.staat)

    cv
  }


}