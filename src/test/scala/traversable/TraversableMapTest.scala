package traversable

import org.junit.Assert.assertEquals
import org.junit.Test

class TraversableMapTest {

  @Test
  def mapExampleTest() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")

    //when
    val result: Traversable[Int] = list.map((f: String) => f.length)

    //then
    assertEquals(3, result.size)
    assertEquals(true, result.forall((f: Int) => f == 1))
  }

  @Test
  def flatMapExampleTest() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")

    //when
    val result: Traversable[String] = list.flatMap((f: String) => Traversable(f.toLowerCase, f.toUpperCase))

    //then
    assertEquals(6, result.size)
    assertEquals(true, result.forall((f: String) => f.length == 1))
  }

  @Test
  def collectExampleTest() = {
    //given
    val list: Traversable[Any] = List("1", 2, 3.43, true, false)

    //when
    val collect: Traversable[Int] = list.collect(convertFn)

    //then
    assertEquals(5, collect.size)
    assertEquals(Traversable(1, 2, 3, 1, 0), collect)
  }

  val convertFn: PartialFunction[Any, Int] = {
    case i: Int => i;
    case s: String => s.toInt;
    case b: Boolean => if (b) 1 else 0;
    case d: Double => d.toInt;
  }
}
