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
    val anrede: String = findViewById(R.id.editText_anrede).asInstanceOf[EditText].getText.toString
    val firstName: String = findViewById(R.id.editText_vorname).asInstanceOf[EditText].getText.toString
    val secondName: String = findViewById(R.id.editText_famname).asInstanceOf[EditText].getText.toString
    val gebDatum: String = findViewById(R.id.editText_gebdatum).asInstanceOf[EditText].getText.toString
    val gebOrt: String = findViewById(R.id.editText_gebort).asInstanceOf[EditText].getText.toString
    val famStand: String = findViewById(R.id.editText_famstand).asInstanceOf[EditText].getText.toString
    val staat: String = findViewById(R.id.editText_staat).asInstanceOf[EditText].getText.toString


    // I WANT TO WRITE TO THE DATABASE
    aDb.mkRegFormTable().insert(RegForm(Person(anrede,firstName, secondName,gebDatum,gebOrt,famStand,staat)))
  }

  def loadFromDb(view: View): Unit = {
    val i = new Intent(this, classOf[ResListActivity])
    startActivity(i)

  }
}


