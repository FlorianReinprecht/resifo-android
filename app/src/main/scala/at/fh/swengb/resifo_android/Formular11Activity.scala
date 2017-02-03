package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class Formular11Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular11)

    intent = getIntent()
  }

  def goBack(view: View): Unit = {
    val prevView = new Intent(this, classOf[SelectActivity])
    startActivity(prevView)
  }

  def saveData(view: View): Unit = {

    val nachname: String = findViewById(R.id.editText_nachname).asInstanceOf[EditText].getText.toString
    val vorname: String = findViewById(R.id.editText_vorname).asInstanceOf[EditText].getText.toString
    val datum: String = findViewById(R.id.editText_unterkunft_datum).asInstanceOf[EditText].getText.toString
    val unterkunftgeber: Unterkunftgeber = new Unterkunftgeber(nachname, vorname, datum)

    // hier die Datenspeicherung implementieren
    val prevView = new Intent(this, classOf[Formular12Activity])
    bundle = intent.getExtras().getBundle("bundleFormular10Activity")
    bundle.putSerializable("intentFormular11Activity_unterkunftgeber", unterkunftgeber)

    prevView.putExtra("bundleFormular11Activity", bundle)
    startActivity(prevView)
  }

  /*
  def saveObject(view: View): Unit = {
    val nachname: String = findViewById(R.id.editText_nachname).asInstanceOf[EditText].getText.toString
    val vorname: String = findViewById(R.id.editText_unterkunft_datum).asInstanceOf[EditText].getText.toString


  }*/
}