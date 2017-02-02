package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class SelectActivity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select)
  }

  def editForm(view: View):Unit = {
    val editView = new Intent(this, classOf[EditActivity])
    startActivity(editView)
  }
  def newForm(view: View):Unit = {
    val newView = new Intent(this, classOf[Formular01Activity])
    startActivity(newView)
  }

  def getInfo(view: View):Unit = {
    val infoView = new Intent(this, classOf[InformationActivity])
    startActivity(infoView)
  }


}