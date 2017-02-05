package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, Toast}


class Formular03Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular03)

    //intent von voriger Activity übernehmen
    /*
    val intent: Intent = getIntent();
    val person: Person  = intent.getExtras().getBundle("bundlePerson").getSerializable("intentPerson").asInstanceOf[Person]
    println("Test: " + person)*/

    intent = getIntent();

  }

  /*
  def getPrev(view: View):Unit = {
    val prevView = new Intent(this, classOf[Formular02Activity])
    startActivity(prevView)
  }
  */
  def Prev(view : View) : Unit = onBackPressed()


  def getNext(view: View):Unit = {
    val zmrString: String = findViewById(R.id.editText_zmr).asInstanceOf[EditText].getText.toString
    val zmr: Zmr = Zmr(zmrString)

    val nextView = new Intent(this, classOf[Formular04Activity])
    bundle = intent.getExtras().getBundle("bundleFormular02Activity")
    bundle.putSerializable("intentFormular03Activity_ZMR", zmr)
    nextView.putExtra("bundleFormular03Activity", bundle)

    if( zmrString.toString().trim().equals("") ){
      Toast.makeText(getApplicationContext, "Bitte alle Pflichtfelder ausfüllen!", Toast.LENGTH_SHORT).show()
    }
    else{
      startActivity(nextView);
    }

  }
/*
  def saveObject(view: View): Unit = {
    val zmr: String = findViewById(R.id.editText_zmr).asInstanceOf[EditText].getText.toString
  }
*/
}