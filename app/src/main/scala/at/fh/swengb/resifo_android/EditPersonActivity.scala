package at.fh.swengb.resifo_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class EditPersonActivity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_edit_person)
  }


  def saveObject(view: View): Unit = {
    val zusammenfassung: String = findViewById(R.id.textView_zusammenfassung).asInstanceOf[EditText].getText.toString

}