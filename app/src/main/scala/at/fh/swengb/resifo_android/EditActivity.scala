package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class EditActivity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_edit)
  }

  def editPerson(view: View):Unit = {
    val nextView = new Intent(this, classOf[EditPersonActivity])
    startActivity(nextView)
  }
}