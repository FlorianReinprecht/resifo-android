package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Formular01Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular01)
  }

  def getNext(view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular02Activity])
    startActivity(nextView)
  }
}