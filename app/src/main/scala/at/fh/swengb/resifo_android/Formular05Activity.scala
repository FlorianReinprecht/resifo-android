package at.fh.swengb.resifo_android

import android.content.Intent
import android.os.{Bundle, Handler, Message}
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget._
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
import android.location._
import android.support.v7.widget.Toolbar
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
//import com.google.android.gms.maps.GoogleMap
import android.util.Log

/* VERSUCH 2 ======================>
object Formular05Activity {
  private val CONNECTION_FAILURE_RESOLUTION_REQUEST: Int = 9000
}
<======================*/

/* VERSUCH 2 ======================>
class Formular05Activity extends AppCompatActivity with ConnectionCallbacks with OnConnectionFailedListener with LocationListener {
<======================*/

class Formular05Activity extends AppCompatActivity {

  var bundle: Bundle = _
  var intent: Intent = _

  var tvAddress: TextView = null
  var appLocationService: LocationService = null

  /* VERSUCH 2 ======================>
  private var mGoogleApiClient: GoogleApiClient = null
  private var mLocationRequest: LocationRequest = null
  private var currentLatitude: Double = .0
  private var currentLongitude: Double = .0

  val button_get = findViewById(R.id.imageButton_standort).asInstanceOf[ImageButton]
  <======================*/


  /* VERSUCH 1 ======================>
  private var b_get: ImageButton = null
  private var gps: TrackGPS = null
  var longitude: Double = .0
  var latitude: Double = .0
  <======================*/

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_formular05)

    intent = getIntent()

    //val toolbar: Toolbar = findViewById(R.id.toolbar).asInstanceOf[Toolbar]
    //setSupportActionBar(toolbar)
    appLocationService = new LocationService(Formular05Activity.this)
    tvAddress = findViewById(R.id.tvAddress).asInstanceOf[TextView]
    val fab: ImageButton = findViewById(R.id.imageButton_standort).asInstanceOf[ImageButton]
    fab.setOnClickListener(new View.OnClickListener() {
      def onClick(view: View) {
        val networkLocation: Location = appLocationService.getLocation(LocationManager.NETWORK_PROVIDER)
        if (networkLocation != null) {
          val latitude: Double = networkLocation.getLatitude
          val longitude: Double = networkLocation.getLongitude
          val locationAddress: LocationAddress = new LocationAddress()
          locationAddress.getAddressFromLocation(latitude, longitude, getApplicationContext, new GeocoderHandler())
        }
      }
    })

    /* VERSUCH 2 ======================>
    mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build
    mLocationRequest = LocationRequest.create.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setInterval(10 * 1000).setFastestInterval(1 * 1000)

    button_get.setOnClickListener(new View.OnClickListener() {
      @Override
      def onClick(view:View) {
        mGoogleApiClient.connect()
      }
    })
    <======================*/


    /* VERSUCH 1 ======================>
    b_get = findViewById(R.id.imageButton_standort).asInstanceOf[ImageButton]

    b_get.setOnClickListener(new View.OnClickListener() {
      @Override
      def onClick(view:View) {

        gps = new TrackGPS(Formular05Activity.this)

        if(gps.canGetLocations()){

          longitude = gps.getLongitude()
          latitude = gps.getLatitude()

          Toast.makeText(getApplicationContext(),"Longitude: " + longitude.toString + "\nLatitude: " + latitude.toString, Toast.LENGTH_SHORT).show()
        }
        else
        {
          gps.showSettingsAlert()
        }
      }
    })
    <======================*/

  }

  private class GeocoderHandler extends Handler {
    override def handleMessage(message: Message) {
      var locationAddress: String = null
      message.what match {
        case 1 =>
          val bundle: Bundle = message.getData
          locationAddress = bundle.getString("address")
          //break
        case _ =>
          locationAddress = null
      }
      tvAddress.setText(locationAddress)
    }
  }


  /* VERSUCH 1 ======================>
  @Override
  override def onDestroy() {
    super.onDestroy();
    gps.stopUsingGPS();
  }
  <======================*/

  /* VERSUCH 2 ======================>
  @Override
  override protected def onResume {
    super.onResume
    mGoogleApiClient.connect
  }

  @Override
  override protected def onPause {
    super.onPause
    Log.v(this.getClass.getSimpleName, "onPause()")
    if (mGoogleApiClient.isConnected) {
      LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this)
      mGoogleApiClient.disconnect
    }
  }

  def onConnected(bundle: Bundle) {
    val location: Location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient)
    if (location == null) {
      LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this)
    }
    else {
      currentLatitude = location.getLatitude
      currentLongitude = location.getLongitude
      Toast.makeText(this, currentLatitude + " WORKS " + currentLongitude + "", Toast.LENGTH_LONG).show
    }
  }

  def onConnectionSuspended(i: Int) {
  }

  def onConnectionFailed(connectionResult: ConnectionResult) {
    if (connectionResult.hasResolution) {
      try {
        connectionResult.startResolutionForResult(this, Formular05Activity.CONNECTION_FAILURE_RESOLUTION_REQUEST)
      }
      catch {
        case e: Exception => {
          e.printStackTrace
        }
      }
    }
    else {
      Log.e("Error", "Verbindung zur Standortbestimmung fehlgeschlagen (" + connectionResult.getErrorCode + ")")
    }
  }

  def onLocationChanged(location: Location) {
    currentLatitude = location.getLatitude
    currentLongitude = location.getLongitude
    Toast.makeText(this, currentLatitude + " WORKS " + currentLongitude + "", Toast.LENGTH_LONG).show
  }
  <====================== */



  def readInput():Unit = {
    // Einlesen der Daten
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString
    val anmUnterkunft: AnmUnterkunft = AnmUnterkunft(land, plz, ort, straße, tuer, hausnummer, stiege)

    bundle = intent.getExtras().getBundle("bundleFormular04Activity")
    bundle.putSerializable("intentFormular05Activity_anmUnterkunft", anmUnterkunft)
  }


  def getPrev(view: View):Unit = {
    val prevView = new Intent(this, classOf[Formular04Activity])
    startActivity(prevView)
  }

  def Prev(view: View) : Unit = onBackPressed()


  def hwsYes(view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular06Activity])
    readInput()

    bundle.putSerializable("intentFormular08Activity_hauptwohnsitzBleibtIn", new HauptwohnsitzBleibt("","","","","","",""))
    bundle.putSerializable("intentFormular09Activity_ausAuslandziehen", 0)

    nextView.putExtra("bundleFormular05Activity", bundle)

    // Ich habe sie jetzt einfach nochmal eingelesen.. normalerweise müsst ich nur noch die Vals von oben global machen, dann brauchma den unteren teil net
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    //val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].setText("yooo").toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString
    val anmUnterkunft: AnmUnterkunft = AnmUnterkunft(land, plz, ort, straße, tuer, hausnummer, stiege)

    if( land.toString().trim().equals("") || plz.toString().trim().equals("") || ort.toString().trim().equals("") || straße.toString().trim().equals("") || hausnummer.toString().trim().equals("") ){
      Toast.makeText(getApplicationContext, "Bitte alle Pflichtfelder ausfüllen!", Toast.LENGTH_SHORT).show()
    }
    else{
      startActivity(nextView);
    }
  }

  def hwsNo (view: View):Unit = {
    val nextView = new Intent(this, classOf[Formular08Activity])
    readInput()

    bundle.putSerializable("intentFormular06Activity_abmUnterkunft", new AbmUnterkunft("","","","","","",""))
    bundle.putSerializable("intentFormular07Activity_insAuslandziehen", 0)

    nextView.putExtra("bundleFormular05Activity", bundle)
    // Ich habe sie jetzt einfach nochmal eingelesen.. normalerweise müsst ich nur noch die Vals von oben global machen, dann brauchma den unteren teil net
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString
    val anmUnterkunft: AnmUnterkunft = AnmUnterkunft(land, plz, ort, straße, tuer, hausnummer, stiege)
    if( land.toString().trim().equals("") || plz.toString().trim().equals("") || ort.toString().trim().equals("") || straße.toString().trim().equals("") || hausnummer.toString().trim().equals("")){
      Toast.makeText(getApplicationContext, "Bitte alle Pflichtfelder ausfüllen!", Toast.LENGTH_SHORT).show()
    }
    else{
      startActivity(nextView);
    }
  }





  /* VERSUCH 0
  def getLocData(view: View): Unit = {
    val location:Uri = Uri.parse("geo:0,0?q=" + user.getAddress())
    val mapIntent:Intent = new Intent(Intent.ACTION_VIEW, location)
    startActivity(mapIntent)
  }
  */

  /*
  def saveObject(view: View): Unit = {
    val land: String = findViewById(R.id.editText_land).asInstanceOf[EditText].getText.toString
    val plz: String = findViewById(R.id.editText_plz).asInstanceOf[EditText].getText.toString
    val ort: String = findViewById(R.id.editText_ort).asInstanceOf[EditText].getText.toString
    val straße: String = findViewById(R.id.editText_straße).asInstanceOf[EditText].getText.toString
    val tuer: String = findViewById(R.id.editText_tuer).asInstanceOf[EditText].getText.toString
    val hausnummer: String = findViewById(R.id.editText_hausnummer).asInstanceOf[EditText].getText.toString
    val stiege: String = findViewById(R.id.editText_stiege).asInstanceOf[EditText].getText.toString

  }
  */
}