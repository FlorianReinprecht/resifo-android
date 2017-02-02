package at.fh.swengb.resifo_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText




class EditPersonActivity extends AppCompatActivity {

  var person:Person;

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_edit_person)

    val intent: Nothing = getIntent

    person = intent.getExtras.get("person").asInstanceOf[Nothing]

    val viewAnrede: Nothing = findViewById(R.id.textView_anrede).asInstanceOf[Nothing]
    val viewFamiliennameVor: Nothing = findViewById(R.id.textView_familiennameVor).asInstanceOf[Nothing]
    val viewName: Nothing = findViewById(R.id.textView_name).asInstanceOf[Nothing]
    val viewGeburt: Nothing = findViewById(R.id.textView_geburt).asInstanceOf[Nothing]
    val viewReligion: Nothing = findViewById(R.id.textView_religion).asInstanceOf[Nothing]
    val viewFamilienstand: Nothing = findViewById(R.id.textView_familienstand).asInstanceOf[Nothing]
    val viewStaatsangehoerigkeit: Nothing = findViewById(R.id.textView_staatsangehoerigkeit).asInstanceOf[Nothing]
    val viewZmrZahl: Nothing = findViewById(R.id.textView_zmrZahl).asInstanceOf[Nothing]
    val viewReisepassnummer: Nothing = findViewById(R.id.textView_reisepassnummer).asInstanceOf[Nothing]
    val viewAusstellungsdatum: Nothing = findViewById(R.id.textView_ausstellungsdatum).asInstanceOf[Nothing]
    val viewAusstellendeBehoerde: Nothing = findViewById(R.id.textView_ausstellendeBehoerde).asInstanceOf[Nothing]
    val viewAnmStrasse: Nothing = findViewById(R.id.textView_anmStrasse).asInstanceOf[Nothing]
    val viewAnmOrt: Nothing = findViewById(R.id.textView_anmOrt).asInstanceOf[Nothing]
    val viewHauptwohnsitz: Nothing = findViewById(R.id.textView_hauptwohnsitz).asInstanceOf[Nothing]
    val viewHauptStrasse: Nothing = findViewById(R.id.textView_hauptStrasse).asInstanceOf[Nothing]
    val viewHauptOrt: Nothing = findViewById(R.id.textView_hauptOrt).asInstanceOf[Nothing]
    val viewZuzug: Nothing = findViewById(R.id.textView_zuzug).asInstanceOf[Nothing]
    val viewAbmStrasse: Nothing = findViewById(R.id.textView_abmStrasse).asInstanceOf[Nothing]
    val viewAbmOrt: Nothing = findViewById(R.id.textView_abmOrt).asInstanceOf[Nothing]
    val viewVerzug: Nothing = findViewById(R.id.textView_verzug).asInstanceOf[Nothing]
    val viewUnterkunftNachname: Nothing = findViewById(R.id.textView_unterkunftNachname).asInstanceOf[Nothing]
    val viewUnterkunftVorname: Nothing = findViewById(R.id.textView_unterkunftVorname).asInstanceOf[Nothing]
    val viewUnterkunftDatum: Nothing = findViewById(R.id.textView_unterkunftDatum).asInstanceOf[Nothing]


    val viewAnrede.setText(person.getAnrede)
    val viewFamiliennameVor.setText(person.getFamiliennameVor)
    val viewName.setText(person.getName)
    val viewGeburt.setText(person.getGeburt)
    val viewReligion.setText(person.getReligion)
    val viewFamilienstand.setText(person.getFamilienstand)
    val viewStaatsangehoerigkeit.setText(person.getStaatsangehoerigkeit)
    val viewZmrZahl.setText(person.getZmrZahl)


    val viewReisepassnummer.setText(person.getReisepassnummer)
    val viewAusstellungsdatum.setText(person.getAusstellungsdatum)
    val viewAusstellendeBehoerde.setText(person.getAusstellendeBehoerde)

    val viewAnmStrasse.setText(person.getAnmStrasse)
    val viewAnmOrt.setText(person.getAnmOrt)
    val viewHauptwohnsitz.setText(person.getHauptwohnsitz)

    val viewHauptStrasse.setText(person.getHauptStrasse)
    val viewHauptOrt.setText(person.getHauptOrt)
    val viewZuzug.setText(person.getZuzug)

    val viewAbmStrasse.setText(person.getAbmStrasse)
    val viewAbmOrt.setText(person.getAbmOrt)
    val viewVerzug.setText(person.getVerzug)

    val viewUnterkunftNachname.setText(person.getUnterkunftNachname)
    val viewUnterkunftVorname.setText(person.getUnterkunftVorname)
    val viewUnterkunftDatum.setText(person.getUnterkunftDatum)


  }


  def saveObject(view: View): Unit = {
    val zusammenfassung: String = findViewById(R.id.textView_zusammenfassung).asInstanceOf[EditText].getText.toString

  }





}