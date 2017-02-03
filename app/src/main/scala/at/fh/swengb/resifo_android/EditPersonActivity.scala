package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, TextView}


class EditPersonActivity extends AppCompatActivity {
  var aDb: ResDb = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_edit_person)

    val intent: Intent = getIntent();
    val regForm :RegForm = intent.getExtras().getBundle("bundleRegForm").getSerializable("intentRegForm").asInstanceOf[RegForm]

    val viewPersonAnrede: TextView = findViewById(R.id.textView_personAnrede).asInstanceOf[TextView]
    viewPersonAnrede.setText("Anrede: "+ regForm.person.anrede)

    val viewFamiliennameVor: TextView = findViewById(R.id.textView_familiennameVor).asInstanceOf[TextView]
    viewFamiliennameVor.setText("Familienname vor der ersten Ehe: "+regForm.person.famnameVor)

    val viewName: TextView = findViewById(R.id.textView_name).asInstanceOf[TextView]
    viewName.setText("Name: "+regForm.person.firstName+ " "+regForm.person.secondName)

    val viewGeburt: TextView = findViewById(R.id.textView_geburt).asInstanceOf[TextView]
    viewGeburt.setText("Geburtsdaten: " + regForm.person.gebDatum + ", " + regForm.person.gebOrt)

    val viewFamilienstand: TextView = findViewById(R.id.textView_familienstand).asInstanceOf[TextView]
    viewFamilienstand.setText("Familienstand: "+regForm.person.famStand)

    val viewReligion: TextView = findViewById(R.id.textView_religion).asInstanceOf[TextView]
    viewReligion.setText("Religion: "+regForm.person.religion)

    val viewStaatsangehoerigkeit: TextView = findViewById(R.id.textView_staatsangehoerigkeit).asInstanceOf[TextView]
    viewStaatsangehoerigkeit.setText("Staatsangehörgkeit: "+ regForm.person.staat)

    val viewZmrZahl: TextView = findViewById(R.id.textView_zmrZahl).asInstanceOf[TextView]
    viewZmrZahl.setText("ZMR-Zahl: "+ regForm.zmr.zmr)

    val viewReisedokumentArt: TextView = findViewById(R.id.textView_art).asInstanceOf[TextView]
    viewReisedokumentArt.setText("Art: "+ regForm.reisepass.art)

    val viewReisedokumentNummer: TextView = findViewById(R.id.textView_rdNr).asInstanceOf[TextView]
    viewReisedokumentNummer.setText("Nr: "+ regForm.reisepass.nr)

    val viewAusstellungsdatum: TextView = findViewById(R.id.textView_ausstellungsdatum).asInstanceOf[TextView]
    viewAusstellungsdatum.setText("Ausstellungsdatum: "+regForm.reisepass.ausstellungsdatum)

    val viewAusstellendeBehoerde: TextView = findViewById(R.id.textView_ausstellendeBehoerde).asInstanceOf[TextView]
    viewAusstellendeBehoerde.setText("Ausstellende Behörde :"+regForm.reisepass.behoerde)

    val viewAnmStrasse: TextView = findViewById(R.id.textView_anmStrasse).asInstanceOf[TextView]
    viewAnmStrasse.setText("Adresse: "+ regForm.anmUnterkunft.straße + " " + regForm.anmUnterkunft.hausnummer + "/" + regForm.anmUnterkunft.stiege + "/" + regForm.anmUnterkunft.tuer )

    val viewAnmOrt: TextView = findViewById(R.id.textView_anmOrt).asInstanceOf[TextView]
    viewAnmOrt.setText("PLZ, Ort: "+ regForm.anmUnterkunft.plz +", "+ regForm.anmUnterkunft.ort)

    //"Ist das Ihr Hauptwohnsitz?"
    val viewHauptwohnsitz: TextView = findViewById(R.id.textView_hauptwohnsitz).asInstanceOf[TextView]


    val viewHauptStrasse: TextView = findViewById(R.id.textView_hauptStrasse).asInstanceOf[TextView]
    viewHauptStrasse.setText("Adresse: "+ regForm.hauptwohnsitzBleibt.straße + " " + regForm.hauptwohnsitzBleibt.hausnummer + "/" + regForm.hauptwohnsitzBleibt.stiege + "/" + regForm.hauptwohnsitzBleibt.tuer )

    val viewHauptOrt: TextView = findViewById(R.id.textView_hauptOrt).asInstanceOf[TextView]
    viewHauptOrt.setText("PLZ, Ort: "+ regForm.hauptwohnsitzBleibt.plz +", "+ regForm.hauptwohnsitzBleibt.ort)

    //"Ziehen Sie aus dem Ausland?"
    val viewZuzug: TextView = findViewById(R.id.textView_zuzug).asInstanceOf[TextView]

    val viewAbmStrasse: TextView = findViewById(R.id.textView_abmStrasse).asInstanceOf[TextView]
    viewAbmStrasse.setText("Adresse: "+ regForm.abmUnterkunft.straße + " " + regForm.abmUnterkunft.hausnummer + "/" + regForm.abmUnterkunft.stiege + "/" + regForm.abmUnterkunft.tuer )

    val viewAbmOrt: TextView = findViewById(R.id.textView_abmOrt).asInstanceOf[TextView]
    viewAbmOrt.setText("PLZ, Ort: "+ regForm.abmUnterkunft.plz +", "+ regForm.abmUnterkunft.ort)

    //"Verziehen Sie ins Ausland?"
    val viewVerzug: TextView = findViewById(R.id.textView_verzug).asInstanceOf[TextView]

    val viewUnterkunftNachname: TextView = findViewById(R.id.textView_unterkunftNachname).asInstanceOf[TextView]
    viewUnterkunftNachname.setText("Nachname: "+ regForm.unterkunftgeber.nachname)

    val viewUnterkunftVorname: TextView = findViewById(R.id.textView_unterkunftVorname).asInstanceOf[TextView]
    viewUnterkunftNachname.setText("Vorname: "+ regForm.unterkunftgeber.vorname)

    val viewUnterkunftDatum: TextView = findViewById(R.id.textView_unterkunftDatum).asInstanceOf[TextView]
    viewUnterkunftDatum.setText("Datum: "+ regForm.unterkunftgeber.datum)



  }

 /*
  def saveObject(view: View): Unit = {
    val zusammenfassung: String = findViewById(R.id.textView_zusammenfassung).asInstanceOf[EditText].getText.toString

  }
  */




}