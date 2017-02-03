package at.fh.swengb.resifo_android

/**
  * Created by Florian on 05.01.2017.
  */
case class RegForm(person: Person, zmr:Zmr, reisepass: Reisepass, anmUnterkunft: AnmUnterkunft,
                   an_hauptWS:Boolean=true, hauptwohnsitzBleibt: HauptwohnsitzBleibt, abmUnterkunft: AbmUnterkunft, ausland:Boolean=false, korrekt:Boolean=true, unterkunftgeber: Unterkunftgeber) {



  override def toString():String =  {
  "%s %s, %s, %s".format(person.firstName,person.secondName,person.gebDatum,person.gebOrt)
  }
}


