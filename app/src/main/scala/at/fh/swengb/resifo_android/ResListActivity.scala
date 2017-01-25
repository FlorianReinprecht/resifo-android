package at.fh.swengb.resifo_android

import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.{ArrayAdapter, ListView}

import scala.collection.JavaConversions._

/**
  * Created by lad on 19/01/2017.
  */
class ResListActivity extends ListActivity {

  var aDb: ResDb = _

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)

    aDb = ResDb(getApplicationContext)

    val persons: List[RegForm] = aDb.mkRegFormTable().listByFirstName("Florian")
    //val persons: List[Person] = List(Person("Florian","Reinprecht"),Person("Agnesa","Haxha"))

    val pA = new ArrayAdapter[RegForm](this, android.R.layout.simple_list_item_1, persons)

    setListAdapter(pA)
  }

  override def onListItemClick(l: ListView, v: View, pos: Int, i: Long) {
    println("Pos: " + pos + " clicked")
    val p  = l.getAdapter.getItem(pos).asInstanceOf[RegForm]
    println(p)
  }
}