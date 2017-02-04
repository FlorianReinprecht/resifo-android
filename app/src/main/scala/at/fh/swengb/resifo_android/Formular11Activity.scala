package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{EditText, Toast}

class Formular11Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  var regForm: RegForm = _
  var aDb: ResDb = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular11)
    aDb = ResDb(getApplicationContext)

    intent = getIntent()

  }

  def goBack(view: View): Unit = {
    val prevView = new Intent(this, classOf[SelectActivity])
    startActivity(prevView)
  }

  def saveData(view: View): Unit = {

    bundle = intent.getExtras().getBundle("bundleFormular10Activity")
    val person: Person = intent.getExtras().getBundle("bundleFormular10Activity").getSerializable("intentFormular01Activity_Person").asInstanceOf[Person]
    val zmr: Zmr = intent.getExtras().getBundle("bundleFormular10Activity").getSerializable("intentFormular03Activity_ZMR").asInstanceOf[Zmr]
    val reisepass: Reisepass = intent.getExtras().getBundle("bundleFormular10Activity").getSerializable("intentFormular04Activity_reisepass").asInstanceOf[Reisepass]
    val anmUnterkunft: AnmUnterkunft = intent.getExtras().getBundle("bundleFormular10Activity").getSerializable("intentFormular05Activity_anmUnterkunft").asInstanceOf[AnmUnterkunft]
    val abmUnterkunft: AbmUnterkunft = intent.getExtras().getBundle("bundleFormular10Activity").getSerializable("intentFormular06Activity_abmUnterkunft").asInstanceOf[AbmUnterkunft]
    val insAuslandziehen:Int = intent.getExtras().getBundle("bundleFormular10Activity").getSerializable("intentFormular07Activity_insAuslandziehen").asInstanceOf[Int]
    val hauptwohnsitzBleibtIn:HauptwohnsitzBleibt = intent.getExtras().getBundle("bundleFormular10Activity").getSerializable("intentFormular08Activity_hauptwohnsitzBleibtIn").asInstanceOf[HauptwohnsitzBleibt]
    val ausAuslandziehen:Int = intent.getExtras().getBundle("bundleFormular10Activity").getSerializable("intentFormular09Activity_ausAuslandziehen").asInstanceOf[Int]

    val nachname: String = findViewById(R.id.editText_nachname).asInstanceOf[EditText].getText.toString
    val vorname: String = findViewById(R.id.editText_vorname).asInstanceOf[EditText].getText.toString
    val datum: String = findViewById(R.id.editText_unterkunft_datum).asInstanceOf[EditText].getText.toString
    val unterkunftgeber: Unterkunftgeber = new Unterkunftgeber(nachname, vorname, datum)

    regForm = RegForm(person,zmr,reisepass,anmUnterkunft,hauptwohnsitzBleibtIn,abmUnterkunft,unterkunftgeber)

    val prevView = new Intent(this, classOf[Formular12Activity])
    bundle = intent.getExtras().getBundle("bundleFormular10Activity")
    bundle.putSerializable("intentFormular11Activity_unterkunftgeber", unterkunftgeber)

    prevView.putExtra("bundleFormular11Activity", bundle)

    aDb.mkRegFormTable().insert(regForm)
    println(regForm)

    if( nachname.toString().trim().equals("") || vorname.toString().trim().equals("") || datum.toString().trim().equals("")){
      Toast.makeText(getApplicationContext, "Alle Pflichtfelder müssen ausgefüllt werden!", Toast.LENGTH_SHORT).show()
    }
    else{
      startActivity(prevView);
    }

  }

}