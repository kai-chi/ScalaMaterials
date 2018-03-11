val opt = Some(1)
val none = None

// Option [T]

opt.get

case class User(val name: String, val city: Option[String])

val user1 = new User("fred", Some("London"))
val user2 = new User("jill", None)

user1.city.get
user2.city.getOrElse("no city")

def getCity(u: User) = u.city match {
  case Some(c) => c
  case None => "no city"
}

getCity(user1)

val users = List(
  User("jill", Some("Warsaw")),
  User("dave", None),
  User("paul", Some("London")),
  User("marie", None)
)

val cities = users.flatMap(x => x.city)