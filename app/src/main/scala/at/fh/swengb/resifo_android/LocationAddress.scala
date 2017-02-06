package at.fh.swengb.resifo_android

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import java.io.IOException
import java.util.List
import java.util.Locale

class LocationAddress {
  private val TAG: String = "LocationAddress"

  def getAddressFromLocation(latitude: Double, longitude: Double, context: Context, handler: Handler) {
    val thread: Thread = new Thread() {
      override def run {
        val geocoder: Geocoder = new Geocoder(context, Locale.getDefault)
        var result: String = null
        try {
          val addressList: List[Address] = geocoder.getFromLocation(latitude, longitude, 1)
          if (addressList != null && addressList.size > 0) {
            val address: Address = addressList.get(0)
            val sb: StringBuilder = new StringBuilder
            var i: Int = 0
            while (i < address.getMaxAddressLineIndex) {
                sb.append(address.getAddressLine(i)).append("\n")
                i += 1; i - 1
            }
            sb.append(address.getLocality).append("\n")
            sb.append(address.getPostalCode).append("\n")
            sb.append(address.getCountryName)
            result = sb.toString
          }
        }

        catch {
          case e: IOException => Log.e(TAG, "Keine Verbindung zum Geocoder möglich.", e)
        } finally {
          val message: Message = Message.obtain
          message.setTarget(handler)
          if (result != null) {
            message.what = 1
            val bundle: Bundle = new Bundle
            result = "Latitude: " + latitude + " Longitude: " + longitude + "\n\nAdresse:\n" + result
            bundle.putString("Adresse", result)
            message.setData(bundle)
          }
          else {
            message.what = 1
            val bundle: Bundle = new Bundle
            result = "Latitude: " + latitude + " Longitude: " + longitude + "\n Für diese Koordinaten gibt es keine Adresse."
            bundle.putString("Adresse", result)
            message.setData(bundle)
          }
          message.sendToTarget()
        }
      }
    }
    thread.start()
  }
}