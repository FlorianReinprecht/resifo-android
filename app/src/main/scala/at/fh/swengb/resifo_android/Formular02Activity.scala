package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Formular02Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular02)
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
    startActivity(zmrY)
  }

  def zmrNo(view: View):Unit = {
    val zmrN = new Intent(this, classOf[Formular04Activity])
    startActivity(zmrN)
  }


}