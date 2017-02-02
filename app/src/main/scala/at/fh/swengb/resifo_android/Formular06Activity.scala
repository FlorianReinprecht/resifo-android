package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Formular06Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular06)
  }

  def getPrev(view: View): Unit = {
    val prevView = new Intent(this, classOf[Formular05Activity])
    startActivity(prevView)
  }

  def getNext(view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular07Activity])
    startActivity(nextView)
  }
  def saveObject(view: View): Unit = {
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString

  }
}