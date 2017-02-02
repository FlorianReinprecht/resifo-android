package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View


class Formular07Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular07)
  }

  /*
  def getPrev(view: View): Unit = {
    val prevView = new Intent(this, classOf[Formular06Activity])
    startActivity(prevView)
  }
  */

  def Prev(view : View) : Unit = onBackPressed()

  def auslandYes(view: View):Unit = {
    // hier irgendetwas implementieren, das "ins Ausland ziehen" auf JA setzt
    val nextView = new Intent(this, classOf[Formular10Activity])
    startActivity(nextView)
  }

  def auslandNo (view: View):Unit = {
    // hier irgendetwas implementieren, das "ins Ausland ziehen" auf NEIN setzt
    val nextView = new Intent(this, classOf[Formular10Activity])
    startActivity(nextView)
  }
}