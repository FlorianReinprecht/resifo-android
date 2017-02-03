package at.fh.swengb.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
//  println(RegForm(Person("Herr", "Florian", "Reinprecht","10.12.1994","Feldbach","ledig","Österreich")))



  def gotoFirstActivity(view: View):Unit = {
    val i = new Intent(this, classOf[SelectActivity])
    startActivity(i)
  }
}