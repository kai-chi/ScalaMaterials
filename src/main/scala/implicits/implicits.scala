package implicits

package object implicits {
    implicit def `appleToOrange3.5`(apple: Apple): Orange =
      Orange("3.5")
}
