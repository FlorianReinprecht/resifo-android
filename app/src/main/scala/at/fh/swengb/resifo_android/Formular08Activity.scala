package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText



class Formular08Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular08)

    intent = getIntent();
  }

  /*
  def getPrev(view: View): Unit = {
    val prevView = new Intent(this, classOf[Formular05Activity])
    startActivity(prevView)
  }
  */
  def Prev(view : View) : Unit = onBackPressed()


  def getNext(view: View): Unit = {
    val prevView = new Intent(this, classOf[Formular09Activity])

    //Einlesen der Daten
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString
    val hauptwohnsitzBleibtIn: HauptwohnsitzBleibt = HauptwohnsitzBleibt(land, plz, ort, straße, tuer, hausnummer, stiege)

    bundle = intent.getExtras().getBundle("bundleFormular05Activity")
    bundle.putSerializable("intentFormular08Activity_hauptwohnsitzBleibtIn", hauptwohnsitzBleibtIn)

    prevView.putExtra("bundleFormular08Activity", bundle)
    startActivity(prevView)
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