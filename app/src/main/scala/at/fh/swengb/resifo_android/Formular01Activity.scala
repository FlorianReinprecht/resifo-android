package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class Formular01Activity extends AppCompatActivity {

  var aDb: ResDb = _

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular01)
    aDb = ResDb(getApplicationContext)
  }

  def getNext(view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular02Activity])
    startActivity(nextView)
  }

  def saveToDb(view: View): Unit = {
    val secondName: String = findViewById(R.id.editText_famname).asInstanceOf[EditText].getText.toString
    val firstName: String = findViewById(R.id.editText3_vorname).asInstanceOf[EditText].getText.toString

    // I WANT TO WRITE TO THE DATABASE
    aDb.mkPersonTable().insert(Person(firstName, secondName))
  }

  def loadFromDb(view: View): Unit = {
    val i = new Intent(this, classOf[ResListActivity])
    startActivity(i)

  }
}


