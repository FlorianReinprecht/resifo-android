package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils.SimpleStringSplitter
import android.view.View
import android.widget.EditText

class Formular05Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular05)

    intent = getIntent();

  }

  def readInput ():Unit = {
    //Einlesen der Daten
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString
    val anmUnterkunft: AnmUnterkunft = AnmUnterkunft(land, plz, ort, straße, tuer, hausnummer, stiege)

    bundle = intent.getExtras().getBundle("bundleFormular04Activity")
    bundle.putSerializable("intentFormular05Activity_anmUnterkunft", anmUnterkunft)
  }


  def getPrev(view: View):Unit = {
    val prevView = new Intent(this, classOf[Formular04Activity])
    startActivity(prevView)
  }

  def Prev(view : View) : Unit = onBackPressed()


  def hwsYes(view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular06Activity])
    readInput()

    bundle.putSerializable("intentFormular08Activity_hauptwohnsitzBleibtIn", new HauptwohnsitzBleibt("","","","","","",""))
    bundle.putSerializable("intentFormular09Activity_ausAuslandziehen", 0)

    nextView.putExtra("bundleFormular05Activity", bundle)
    startActivity(nextView)
  }

  def hwsNo (view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular08Activity])
    readInput()

    bundle.putSerializable("intentFormular06Activity_abmUnterkunft", new AbmUnterkunft("","","","","","",""))
    bundle.putSerializable("intentFormular07Activity_insAuslandziehen", 0)

    nextView.putExtra("bundleFormular05Activity", bundle)
    startActivity(nextView)
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