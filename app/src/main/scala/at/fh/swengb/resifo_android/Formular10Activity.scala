package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Formular10Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular10)
  }

  /*
  def getPrev(view: View): Unit = {
    val prevView = new Intent(this, classOf[Formular05Activity])
    startActivity(prevView)
  }
  */
  def Prev(view : View) : Unit = onBackPressed()


  def getNext(view: View): Unit = {
    val prevView = new Intent(this, classOf[Formular11Activity])
    startActivity(prevView)
  }
}