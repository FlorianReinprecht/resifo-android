package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, Toast}


class Formular04Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular04)

    intent = getIntent();

    /*
    val person: Person  = intent.getExtras().getBundle("bundleFormular03Activity").getSerializable("intentFormular03Activity_Person").asInstanceOf[Person]
    val zmr: Zmr  = intent.getExtras().getBundle("bundleFormular03Activity").getSerializable("intentFormular03Activity_ZMR").asInstanceOf[Zmr]
  */
  }

  /*
  def getPrev(view: View):Unit = {
    val prevView = new Intent(this, classOf[Formular02Activity])
    startActivity(prevView)
  }
  */
  def Prev(view : View) : Unit = onBackPressed()


  def getNext(view: View):Unit = {
    val docart: String = findViewById(R.id.editText_art).asInstanceOf[EditText].getText.toString
    val docNr: String = findViewById(R.id.editText_rdNr).asInstanceOf[EditText].getText.toString
    val ausstellungsdatum: String = findViewById(R.id.editText_ausstellungsdatum).asInstanceOf[EditText].getText.toString
    val behoerde: String = findViewById(R.id.editText_behoerde).asInstanceOf[EditText].getText.toString
    val reisepass: Reisepass = Reisepass(docart, docNr, ausstellungsdatum, behoerde)

    val nextView = new Intent(this, classOf[Formular05Activity])

    bundle = intent.getExtras().getBundle("bundleFormular03Activity")
    bundle.putSerializable("intentFormular04Activity_reisepass", reisepass)
    nextView.putExtra("bundleFormular04Activity", bundle)
    if( docart.toString().trim().equals("") || docNr.toString().trim().equals("") || ausstellungsdatum.toString().trim().equals("") || behoerde.toString().trim().equals("") || reisepass.toString().trim().equals("")){
      Toast.makeText(getApplicationContext, "Bitte alle Pflichtfelder ausfüllen!", Toast.LENGTH_SHORT).show()
    }
    else{
      startActivity(nextView);
    }
  }
/*
  def saveObject(view: View): Unit = {
    val art: String = findViewById(R.id.editText_art).asInstanceOf[EditText].getText.toString
    val ausstellungsdatum: String = findViewById(R.id.editText_ausstellungsdatum).asInstanceOf[EditText].getText.toString
    val behoerde: String = findViewById(R.id.editText_behoerde).asInstanceOf[EditText].getText.toString
  }*/
}