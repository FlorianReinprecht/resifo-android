package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Formular09Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular09)
  }

  /*
  def getPrev(view: View): Unit = {
    val prevView = new Intent(this, classOf[Formular08Activity])
    startActivity(prevView)
  }
  */
  def Prev(view : View) : Unit = onBackPressed()


  def auslandYes(view: View): Unit = {
    // hier irgendetwas implementieren, das "aus Ausland herziehen" auf JA setzt
    val prevView = new Intent(this, classOf[Formular10Activity])
    startActivity(prevView)
  }

  def auslandNo(view: View): Unit = {
    // hier irgendetwas implementieren, das "aus Ausland herziehen" auf NEIN setzt
    val prevView = new Intent(this, classOf[Formular10Activity])
    startActivity(prevView)
  }
}