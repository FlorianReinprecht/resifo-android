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
      "(id INTEGER PRIMARY KEY ASC, anrede TEXT, titel TEXT, firstname TEXT, secondname TEXT, famnameVor TEXT, gebDatum TEXT, gebOrt TEXT, famstand TEXT, religion TEXT, staat TEXT, zmr TEXT," +
      "art TEXT, rdNr TEXT, ausstDatum TEXT, auszuBHD TEXT, an_land TEXT, an_strasse TEXT,an_hausNr TEXT, an_stiege TEXT, an_tuerNr TEXT," +
      "an_plz TEXT, an_ort TEXT, haupt_land TEXT, haupt_plz TEXT, haupt_ort TEXT, haupt_strasse TEXT, haupt_tuerNr TEXT, haupt_hausNr TEXT, haupt_stiege TEXT," +
      "ab_land TEXT, ab_strasse TEXT, ab_hausNr TEXT, ab_stiege TEXT, ab_tuerNr TEXT," +
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

    def deleteByRegForm(regForm: RegForm) : Unit = {
      db.delete("regForm", "firstname = ? and secondname= ? and gebDatum = ?",  Array(regForm.person.firstName,regForm.person.secondName,regForm.person.gebDatum))
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
              val zmr = c.getString(c.getColumnIndex("zmr"))

              val art = c.getString(c.getColumnIndex("art"))
              val rdNr = c.getString(c.getColumnIndex("rdNr"))
              val ausstDatum = c.getString(c.getColumnIndex("ausstDatum"))
              val auszuBHD = c.getString(c.getColumnIndex("auszuBHD"))

              val an_land = c.getString(c.getColumnIndex("an_land"))
              val an_strasse = c.getString(c.getColumnIndex("an_strasse"))
              val an_hausNr = c.getString(c.getColumnIndex("an_hausNr"))
              val an_stiege = c.getString(c.getColumnIndex("an_stiege"))
              val an_tuerNr = c.getString(c.getColumnIndex("an_tuerNr"))
              val an_plz = c.getString(c.getColumnIndex("an_plz"))
              val an_ort = c.getString(c.getColumnIndex("an_ort"))

              val haupt_land = c.getString(c.getColumnIndex("haupt_land"))
              val haupt_strasse = c.getString(c.getColumnIndex("haupt_strasse"))
              val haupt_hausNr = c.getString(c.getColumnIndex("haupt_hausNr"))
              val haupt_stiege = c.getString(c.getColumnIndex("haupt_stiege"))
              val haupt_tuerNr = c.getString(c.getColumnIndex("haupt_tuerNr"))
              val haupt_plz = c.getString(c.getColumnIndex("haupt_plz"))
              val haupt_ort = c.getString(c.getColumnIndex("haupt_ort"))

              val ab_land = c.getString(c.getColumnIndex("ab_land"))
              val ab_strasse = c.getString(c.getColumnIndex("ab_strasse"))
              val ab_hausNr = c.getString(c.getColumnIndex("ab_hausNr"))
              val ab_stiege = c.getString(c.getColumnIndex("ab_stiege"))
              val ab_tuerNr = c.getString(c.getColumnIndex("ab_tuerNr"))
              val ab_plz = c.getString(c.getColumnIndex("ab_plz"))
              val ab_ort = c.getString(c.getColumnIndex("ab_ort"))

              val unter_secondname = c.getString(c.getColumnIndex("unter_secondname"))
              val unter_firstname = c.getString(c.getColumnIndex("unter_firstname"))
              val unter_datum = c.getString(c.getColumnIndex("unter_datum"))


              lb.append(RegForm(Person(anrede, titel, firstName, secondName, famnameVor, gebDatum, gebOrt, famStand,religion, staat),
                                Zmr(zmr), Reisepass(art, rdNr, ausstDatum,auszuBHD),
                                AnmUnterkunft(an_land,an_plz, an_ort, an_strasse, an_tuerNr, an_hausNr, an_stiege),
                                HauptwohnsitzBleibt(haupt_land, haupt_plz, haupt_ort, haupt_strasse, haupt_tuerNr, haupt_hausNr, haupt_stiege),
                                AbmUnterkunft(ab_land, ab_plz, ab_ort, ab_strasse, ab_tuerNr, ab_hausNr, ab_stiege),
                                Unterkunftgeber(unter_secondname,unter_firstname,unter_datum)))
            }
            lb.toList
        }
      } finally {
        cursorRegForm foreach (_.close())

      }

    }


    def regFormCursor(): Option[Cursor] = {
      Option(db.query("RegForm", Array("id", "anrede","titel", "firstname", "secondname", "famnameVor", "gebDatum","gebOrt","famstand","religion","staat",
        "zmr","art","rdNr","ausstDatum","auszuBHD",
        "an_land","an_strasse","an_hausNr", "an_stiege", "an_tuerNr", "an_plz", "an_ort",
        "haupt_land", "haupt_plz", "haupt_ort", "haupt_strasse", "haupt_tuerNr", "haupt_hausNr", "haupt_stiege",
        "ab_land", "ab_strasse", "ab_hausNr", "ab_stiege", "ab_tuerNr", "ab_plz", "ab_ort",
        "unter_secondname", "unter_firstname", "unter_datum"), null, null, null, null, null))
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

    cv.put("zmr",r.zmr.zmr)

    cv.put("art", r.reisepass.art)
    cv.put("rdNr", r.reisepass.nr)
    cv.put("ausstDatum", r.reisepass.ausstellungsdatum)
    cv.put("auszuBHD", r.reisepass.behoerde)
    
    cv.put("an_land", r.anmUnterkunft.land)
    cv.put("an_strasse", r.anmUnterkunft.straße)
    cv.put("an_hausNr", r.anmUnterkunft.hausnummer)
    cv.put("an_stiege", r.anmUnterkunft.stiege)
    cv.put("an_tuerNr", r.anmUnterkunft.tuer)
    cv.put("an_plz", r.anmUnterkunft.plz)
    cv.put("an_ort", r.anmUnterkunft.ort)

    cv.put("haupt_land", r.hauptwohnsitzBleibt.land)
    cv.put("haupt_strasse", r.hauptwohnsitzBleibt.straße)
    cv.put("haupt_hausNr", r.hauptwohnsitzBleibt.hausnummer)
    cv.put("haupt_stiege", r.hauptwohnsitzBleibt.stiege)
    cv.put("haupt_tuerNr", r.hauptwohnsitzBleibt.tuer)
    cv.put("haupt_plz", r.hauptwohnsitzBleibt.plz)
    cv.put("haupt_ort", r.hauptwohnsitzBleibt.ort)

    cv.put("ab_land", r.abmUnterkunft.land)
    cv.put("ab_strasse", r.abmUnterkunft.straße)
    cv.put("ab_hausNr", r.abmUnterkunft.hausnummer)
    cv.put("ab_stiege", r.abmUnterkunft.stiege)
    cv.put("ab_tuerNr", r.abmUnterkunft.tuer)
    cv.put("ab_plz", r.abmUnterkunft.plz)
    cv.put("ab_ort", r.abmUnterkunft.ort)

    cv.put("unter_secondname", r.unterkunftgeber.nachname)
    cv.put("unter_firstname", r.unterkunftgeber.vorname)
    cv.put("unter_datum", r.unterkunftgeber.datum)

    cv
  }


}