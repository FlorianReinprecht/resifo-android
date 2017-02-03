package at.fh.swengb.resifo_android


case class Person(anrede: String, titel: String ="", firstName: String, secondName: String, famnameVor: String ="", gebDatum:String, gebOrt:String, famStand: String,
                  staat: String) extends Serializable
