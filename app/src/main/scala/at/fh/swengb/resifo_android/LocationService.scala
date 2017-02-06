package at.fh.swengb.resifo_android

import android.Manifest
import android.app.Service
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast

object LocationService {
  private val MIN_DISTANCE_FOR_UPDATE: Long = 10
  private val MIN_TIME_FOR_UPDATE: Long = 1000 * 60 * 2
}

class LocationService(val context: Context) extends Service with LocationListener {
  protected var locationManager: LocationManager = null
  locationManager = context.getSystemService(Context.LOCATION_SERVICE).asInstanceOf[LocationManager]
  var location: Location = null

  def getLocation(provider: String): Location = {
    if (locationManager.isProviderEnabled(provider)) {
      try {
        //if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

          Toast.makeText(context, "level 0", Toast.LENGTH_SHORT).show
          locationManager.requestLocationUpdates(provider, LocationService.MIN_TIME_FOR_UPDATE, LocationService.MIN_DISTANCE_FOR_UPDATE, this)
          Toast.makeText(context, "level 1", Toast.LENGTH_SHORT).show
          if (locationManager != null) {
            Toast.makeText(context, "level 2", Toast.LENGTH_SHORT).show
            location = locationManager.getLastKnownLocation(provider)
            return location
          //}
        } else {
          Toast.makeText(context, "Fehlende Berechtigungen!",Toast.LENGTH_SHORT).show
/*
          if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(context, "Berechtigungen zur Standortbestimmung notwendig!", Toast.LENGTH_LONG).show
          }
          ActivityCompat.requestPermissions(this, new Array(Manifest.permission.ACCESS_FINE_LOCATION.toInt), 1);    */
        } // WTF GEHOERT STATT "this" REIN?????? ganz zu schweigen von dem array muell hier drueber
        // https://developer.android.com/training/permissions/requesting.html   */
      }
      catch {
        case e: SecurityException => Toast.makeText(context, "Fehler! Fehlende Berechtigungen!",Toast.LENGTH_SHORT).show
      }
    }
    return null
  }

  def onLocationChanged(location: Location) {
  }

  def onProviderDisabled(provider: String) {
  }

  def onProviderEnabled(provider: String) {
  }

  def onStatusChanged(provider: String, status: Int, extras: Bundle) {
  }

  def onBind(arg0: Intent): IBinder = {
    return null
  }
}