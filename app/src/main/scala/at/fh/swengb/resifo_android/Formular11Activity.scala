package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class Formular11Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular11)
  }

  def goBack(view: View): Unit = {
    val prevView = new Intent(this, classOf[SelectActivity])
    startActivity(prevView)
  }

  def saveData(view: View): Unit = {
    // hier die Datenspeicherung implementieren
    val prevView = new Intent(this, classOf[Formular12Activity])
    startActivity(prevView)
  }

  def saveObject(view: View): Unit = {
    val nachname: String = findViewById(R.id.editText_nachname).asInstanceOf[EditText].getText.toString
    val vorname: String = findViewById(R.id.editText_unterkunft_datum).asInstanceOf[EditText].getText.toString


  }
}