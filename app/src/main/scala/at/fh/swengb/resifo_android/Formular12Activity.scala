package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{RatingBar, Toast}

class Formular12Activity extends AppCompatActivity {
  var bundle: Bundle = _
  var intent: Intent = _
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular12)
    ratingBar = findViewById(R.id.ratingBar).asInstanceOf[RatingBar]

    intent = getIntent();
    bundle = intent.getExtras().getBundle("bundleFormular11Activity")

    val person: Person = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular01Activity_Person").asInstanceOf[Person]
    val zmr: Zmr = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular03Activity_ZMR").asInstanceOf[Zmr]
    val reisepass: Reisepass = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular04Activity_reisepass").asInstanceOf[Reisepass]
    val anmUnterkunft: AnmUnterkunft = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular05Activity_anmUnterkunft").asInstanceOf[AnmUnterkunft]
    val abmUnterkunft: AbmUnterkunft = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular06Activity_abmUnterkunft").asInstanceOf[AbmUnterkunft]
    val insAuslandziehen:Int = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular07Activity_insAuslandziehen").asInstanceOf[Int]
    val hauptwohnsitzBleibtIn:HauptwohnsitzBleibt = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular08Activity_hauptwohnsitzBleibtIn").asInstanceOf[HauptwohnsitzBleibt]
    val ausAuslandziehen:Int = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular09Activity_ausAuslandziehen").asInstanceOf[Int]
    val unterkunftgeber:Unterkunftgeber = intent.getExtras().getBundle("bundleFormular11Activity").getSerializable("intentFormular11Activity_unterkunftgeber").asInstanceOf[Unterkunftgeber]

    val regForm : RegForm = RegForm(person,zmr,reisepass,anmUnterkunft,hauptwohnsitzBleibtIn,abmUnterkunft,unterkunftgeber)

    println(regForm)




  }

  def goBack(view: View): Unit = {
    val prevView = new Intent(this, classOf[SelectActivity])
    startActivity(prevView)
  }

  // Initialize RatingBar
  var ratingBar: RatingBar = null

  /**
    * Display rating by calling getRating() method.
    * @param view
    */
  def rateMe(view:View){

    Toast.makeText(getApplicationContext(), String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
  }





}