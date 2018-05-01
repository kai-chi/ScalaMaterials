//suppose we have a class Foo:
class Foo {
  private var s: Int = ???
  def bar: String = ???
  def baz: Long = ???
}
// suppose bar and baz each mutate s in some way
//we can mechanically translate this to the purely
//functional API by making explicit the transition
//from one state to the next:
trait Foo_1 {
  def bar: (String, Foo_1)
  def baz: (Long, Foo_1)
}