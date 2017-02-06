package at.fh.swengb.resifo_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView

/* === TO-DO LIST ===

- Code mit Kommentaren versehen!!!
- Ablauflogik der einzelnen Screens klaeren + Fortschrittsbalken anpassen
- Felder bei Reisedokumente optional machen
- Alle Datumsfelder & PLZ Felder auf korrekte Eingaben beschränken
- Back-Button nach dem Loeschen eines Datensatzes ueberdenken (zeigt geloeschten Datensatz en, keine Moeglichkeit, um zum Startbildschirm zu kommen!)
- Google Maps Adresse auslesen (long/lat fixen, in Adresse umwandeln & wohl mit setText in die Felder einfuegen)

 */

class MainActivity extends AppCompatActivity{

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
//  println(RegForm(Person("Herr", "Florian", "Reinprecht","10.12.1994","Feldbach","ledig","Österreich")))


  def gotoFirstActivity(view: View):Unit = {
    val i = new Intent(this, classOf[SelectActivity])
    startActivity(i)
  }
}