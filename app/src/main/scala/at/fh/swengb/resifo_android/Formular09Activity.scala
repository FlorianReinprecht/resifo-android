package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Formular09Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular09)

    intent = getIntent();
    bundle = intent.getExtras().getBundle("bundleFormular08Activity")
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
    bundle.putSerializable("intentFormular09Activity_ausAuslandziehen", 1)
    prevView.putExtra("bundleFormular09Activity", bundle)
    startActivity(prevView)
  }

  def auslandNo(view: View): Unit = {
    // hier irgendetwas implementieren, das "aus Ausland herziehen" auf NEIN setzt
    val prevView = new Intent(this, classOf[Formular10Activity])
    bundle.putSerializable("intentFormular09Activity_ausAuslandziehen", 0)
    prevView.putExtra("bundleFormular09Activity", bundle)
    startActivity(prevView)
  }
}