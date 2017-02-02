package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText


class Formular04Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular04)
  }

  /*
  def getPrev(view: View):Unit = {
    val prevView = new Intent(this, classOf[Formular02Activity])
    startActivity(prevView)
  }
  */

  def getNext(view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular05Activity])
    startActivity(nextView)
  }

  def saveObject(view: View): Unit = {
    val art: String = findViewById(R.id.editText_art).asInstanceOf[EditText].getText.toString
    val ausstellungsdatum: String = findViewById(R.id.editText_ausstellungsdatum).asInstanceOf[EditText].getText.toString
    val behoerde: String = findViewById(R.id.editText_behoerde).asInstanceOf[EditText].getText.toString
  }
}