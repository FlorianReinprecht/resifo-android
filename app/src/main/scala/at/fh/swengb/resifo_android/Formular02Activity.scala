package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, TextView}

class Formular02Activity extends AppCompatActivity {
  var intent: Intent = _
  var bundle: Bundle = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular02)

    intent = getIntent()
    bundle = intent.getExtras().getBundle("bundleFormular01Activity")
  }



/*
  def getPrev(view: View):Unit = {
    val prevView = new Intent(this, classOf[Formular01Activity])
    startActivity(prevView)
  }
  */

def Prev(view : View) : Unit = onBackPressed()



  def zmrYes(view: View):Unit = {
    val zmrY = new Intent(this, classOf[Formular03Activity])
    zmrY.putExtra("bundleFormular02Activity",bundle)
    startActivity(zmrY)
  }

  def zmrNo(view: View):Unit = {
    val zmrN = new Intent(this, classOf[Formular04Activity])

    //weil Activity03 übersprungen wird und Activity04 aber eine ZMR benötigt
    bundle.putSerializable("intentFormular03Activity_ZMR", new Zmr(""))

    zmrN.putExtra("bundleFormular03Activity",bundle)
    startActivity(zmrN)
  }


}