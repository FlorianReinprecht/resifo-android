package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Formular10Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular10)

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
    val prevView = new Intent(this, classOf[Formular11Activity])
    bundle = intent.getExtras().getBundle("bundleFormular09Activity")
    prevView.putExtra("bundleFormular10Activity", bundle)
    startActivity(prevView)
  }
}