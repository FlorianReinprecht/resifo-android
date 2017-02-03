package at.fh.swengb.resifo_android

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.{AdapterView, ArrayAdapter, ListView}

import scala.collection.JavaConversions._

/**
  * Created by lad on 19/01/2017.
  */
class ResListActivity extends ListActivity  {

  var aDb: ResDb = _

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.simple_list_item_regform)


    aDb = ResDb(getApplicationContext)

    val regForms: List[RegForm] = aDb.mkRegFormTable().listAll()
    //val persons: List[Person] = List(Person("Florian","Reinprecht"),Person("Agnesa","Haxha"))

    val pA = new ArrayAdapter[RegForm](this, R.layout.simple_list_item_regform,R.id.textViewRegForm,regForms)

    setListAdapter(pA)
  }

  override def onListItemClick(l: ListView, v: View, pos: Int, i: Long) {
    println("Pos: " + pos + " clicked")
    val p  = l.getAdapter.getItem(pos).asInstanceOf[RegForm]
    println(p)
    val intent: Intent = new Intent(this, classOf[EditPersonActivity])

  }

  /*
    def onItemClick(adapterView: Nothing, view: Nothing, i: Int, l: Long) {


    intent.putExtra("user", selectedUser)
    startActivity(intent)
  }




  */

}