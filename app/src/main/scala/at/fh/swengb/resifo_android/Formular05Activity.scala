package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Formular05Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular05)
  }

  def getPrev(view: View):Unit = {
    val prevView = new Intent(this, classOf[Formular04Activity])
    startActivity(prevView)
  }

  def hwsYes(view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular06Activity])
    startActivity(nextView)
  }

  def hwsNo (view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular08Activity])
    startActivity(nextView)
  }
}