package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.{RatingBar, Toast}

class Formular12Activity extends AppCompatActivity {
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular12)
    ratingBar = findViewById(R.id.ratingBar).asInstanceOf[RatingBar]
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