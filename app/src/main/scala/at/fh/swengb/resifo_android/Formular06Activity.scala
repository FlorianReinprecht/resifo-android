package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, Toast}

class Formular06Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular06)

    intent = getIntent();
  }

  /*
  def getPrev(view: View): Unit = {
    val prevView = new Intent(this, classOf[Formular05Activity])
    startActivity(prevView)
  }
  */
  def Prev(view : View) : Unit = onBackPressed()


  def getNext(view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular07Activity])

    //Einlesen der Daten
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString
    val abmUnterkunft: AbmUnterkunft = AbmUnterkunft(land, plz, ort, straße, tuer, hausnummer, stiege)

    bundle = intent.getExtras().getBundle("bundleFormular05Activity")
    bundle.putSerializable("intentFormular06Activity_abmUnterkunft", abmUnterkunft)

    nextView.putExtra("bundleFormular06Activity", bundle)
    if( land.toString().trim().equals("") || plz.toString().trim().equals("") || ort.toString().trim().equals("") || straße.toString().trim().equals("") || hausnummer.toString().trim().equals("")){
      Toast.makeText(getApplicationContext, "Bitte alle Pflichtfelder ausfüllen!", Toast.LENGTH_SHORT).show()
    }
    else{
      startActivity(nextView);
    }
  }

  /*
  def saveObject(view: View): Unit = {
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString

  }*/
}