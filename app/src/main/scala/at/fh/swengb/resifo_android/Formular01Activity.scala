package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{ArrayAdapter, EditText, Spinner}

class Formular01Activity extends AppCompatActivity {

  var aDb: ResDb = _

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular01)
    aDb = ResDb(getApplicationContext)

    val spinner = findViewById(R.id.spinner_famstand).asInstanceOf[Spinner]
    val adapter = ArrayAdapter.createFromResource(this, R.array.array_famstand, android.R.layout.simple_spinner_item)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.setAdapter(adapter)
  }

  def getNext(view: View):Unit = {

    val anrede: String = findViewById(R.id.editText_anrede).asInstanceOf[EditText].getText.toString
    val titel: String = findViewById(R.id.editText_titel).asInstanceOf[EditText].getText.toString
    val firstName: String = findViewById(R.id.editText_unterkunft_datum).asInstanceOf[EditText].getText.toString
    val secondName: String = findViewById(R.id.editText_famname).asInstanceOf[EditText].getText.toString
    val famnameVor: String = findViewById(R.id.editText_famnameVor).asInstanceOf[EditText].getText.toString
    val gebDatum: String = findViewById(R.id.editText_gebdatum).asInstanceOf[EditText].getText.toString
    val gebOrt: String = findViewById(R.id.editText_gebort).asInstanceOf[EditText].getText.toString
    val famStand: String = findViewById(R.id.spinner_famstand).asInstanceOf[Spinner].getSelectedItem.toString
    val religion: String = findViewById(R.id.editText_religion).asInstanceOf[EditText].getText.toString
    val staat: String = findViewById(R.id.editText_staat).asInstanceOf[EditText].getText.toString
    val person: Person = Person(anrede, titel, firstName,secondName,famnameVor,gebDatum,gebOrt,famStand,religion,staat)
    val nextView = new Intent(this, classOf[Formular02Activity])
    val bundle: Bundle = new Bundle();

    bundle.putSerializable("intentFormular01Activity_Person",person)
    nextView.putExtra("bundleFormular01Activity",bundle)
    startActivity(nextView);

  }

  def saveToDb(view: View): Unit = {
    val anrede: String = findViewById(R.id.editText_anrede).asInstanceOf[EditText].getText.toString
    val titel: String = findViewById(R.id.editText_titel).asInstanceOf[EditText].getText.toString
    val firstName: String = findViewById(R.id.editText_unterkunft_datum).asInstanceOf[EditText].getText.toString
    val famnameVor: String = findViewById(R.id.editText_famnameVor).asInstanceOf[EditText].getText.toString
    val secondName: String = findViewById(R.id.editText_famname).asInstanceOf[EditText].getText.toString
    val gebDatum: String = findViewById(R.id.editText_gebdatum).asInstanceOf[EditText].getText.toString
    val gebOrt: String = findViewById(R.id.editText_gebort).asInstanceOf[EditText].getText.toString
    val famStand: String = findViewById(R.id.spinner_famstand).asInstanceOf[Spinner].getSelectedItem.toString
    val religion: String = findViewById(R.id.editText_religion).asInstanceOf[EditText].getText.toString
    val staat: String = findViewById(R.id.editText_staat).asInstanceOf[EditText].getText.toString

    val person: Person = Person(anrede, titel, firstName,secondName,famnameVor,gebDatum,gebOrt,famStand,religion, staat)
    // I WANT TO WRITE TO THE DATABASE
    aDb.mkRegFormTable().insert(RegForm(person,Zmr(""), Reisepass("", "", "",""), AnmUnterkunft("", "", "", "", "", "", ""), HauptwohnsitzBleibt("", "", "", "", "", "", ""), AbmUnterkunft("", "", "", "", "","", ""),Unterkunftgeber("", "","")))
    println(person)

  }
/*
  def loadFromDb(view: View): Unit = {
    val i = new Intent(this, classOf[ResListActivity])
    startActivity(i)
  }
  */

}


