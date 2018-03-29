val person: (String, Int) = ("Antonio", 63)

person match {
  case (name, age) => s"$name is almost ${age + 2 } years old"
}

def describeAge(maybeAge: Option[Int]): String = {
  maybeAge match {
    case None =>
      "I don't know your age!"
    case Some(age) =>
      if (age < 10)
        s"You are a young ${age} years old!"
      else if (age < 25)
        s"You are still learning at $age years old!"
      else
        s"You are a mature $age years old!"
  }
}

describeAge(None)
describeAge(Some(5))
describeAge(Some(12))
describeAge(Some(25))

def describeAge(maybeAge: Option[Int]): String = {
  maybeAge match {
    case None =>
      "I don't know your age!"
    case Some(age) if age < 10 =>
        s"You are a young $age years old!"
    case Some(age) if age < 25 =>
        s"You are still learning at $age years old!"
    case Some(age) =>
        s"You are a mature $age years old!"
  }
}

describeAge(None)
describeAge(Some(5))
describeAge(Some(12))
describeAge(Some(25))

def describePerson(person: (String, Option[Int])): String = {
  person match {
    case (name, age) =>
      s"$name: ${describeAge(age)}"
  }
}

describePerson(("Antonio", None))
describePerson(("Antonio", Some(25)))

def describePerson(person: (String, Option[Int])): String = {
  person match {
    case (name, None) =>
      s"$name has no age."
    case (name, Some(age)) if age < 10 =>
      s"$name is a young $age years old!"
    case (name, Some(age)) if age < 25 =>
      s"$name is still learning at $age years old!"
    case (name, Some(age)) =>
      s"$name is a mature $age years old!"
  }
}

describePerson(("Antonio", None))
describePerson(("Antonio", Some(8)))
describePerson(("Antonio", Some(13)))
describePerson(("Antonio", Some(25)))


def describePerson(person: (String, Option[Int])): String = {
  person match {
    case (name, None) =>
      s"$name has no age."
    case (name, Some(age @ (5 | 8))) =>
      s"$name is a particularly precocious age at $age."
    case (name, Some(age)) if age < 10 =>
      s"$name is a young $age years old!"
    case (name, Some(age)) if age < 25 =>
      s"$name is still learning at $age years old!"
    case (name, Some(age)) =>
      s"$name is a mature $age years old!"
  }
}

describePerson(("Antonio", None))
describePerson(("Antonio", Some(4)))
describePerson(("Antonio", Some(5)))
describePerson(("Antonio", Some(8)))
describePerson(("Antonio", Some(13)))
