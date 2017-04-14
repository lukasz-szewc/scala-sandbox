package traversable

import org.junit.Assert.assertEquals
import org.junit.Test

class TraversableSubcollectionsTest {

  @Test(expected = classOf[UnsupportedOperationException])
  def nilTraversableTail() = {
    //given + when + then
    val tail: List[Nothing] = Nil.tail
  }

  @Test(expected = classOf[UnsupportedOperationException])
  def emptyTraversableTail() = {
    //given + when + then
    val tail: Traversable[Nothing] = Traversable().tail
  }

  @Test
  def ordinaryTraversableTest() = {
    //given
    val list: Traversable[String] = Traversable("a", "b", "c")

    //when + then
    assertEquals(List("b", "c"), list.tail)
    assertEquals(List("a", "b"), list.init)
    assertEquals(List("b"), list.tail.init)
    assertEquals(List("c"), list.tail.tail)
    assertEquals(List(), list.tail.tail.tail)
  }

  @Test
  def sliceTraversableTest() = {
    //given
    val list: Traversable[String] = Traversable("a", "b", "c", "d", "e")

    //when + then
    assertEquals(Traversable("a", "b", "c", "d", "e"), list.slice(0, 5))
    assertEquals(Traversable("b", "c", "d"), list.slice(1, 4))
    assertEquals(Traversable("c"), list.slice(2, 3))
    assertEquals(Traversable(), list.slice(2, 2))
  }

  @Test
  def takeTraversableTest() = {
    //given
    val list: Traversable[String] = Traversable("a", "b", "c", "d", "e")

    //when + then
    assertEquals(Traversable("a", "b", "c", "d", "e"), list.take(5))
    assertEquals(Traversable("a", "b", "c"), list.take(3))
    assertEquals(Traversable("a"), list.take(1))
    assertEquals(Traversable(), list.take(0))
  }

  @Test
  def dropTraversableTest() = {
    //given
    val list: Traversable[String] = Traversable("a", "b", "c", "d", "e")

    //when + then
    assertEquals(Traversable("a", "b", "c", "d", "e"), list.drop(0))
    assertEquals(Traversable("c", "d", "e"), list.drop(2))
    assertEquals(Traversable("e"), list.drop(4))
    assertEquals(Traversable(), list.drop(5))
  }

  @Test
  def takeWhileTraversableTest() = {
    //given
    val list: Traversable[String] = Traversable("a", "b", "c", "d", "e")

    //when + then
    assertEquals(Traversable("a", "b", "c", "d", "e"), list.takeWhile((p: String) => p.length == 1))
    assertEquals(Traversable("a", "b"), list.takeWhile((p: String) => p <= "b"))
    assertEquals(Traversable(), list.takeWhile((p: String) => false))
  }

  @Test
  def dropWhileTraversableTest() = {
    //given
    val list: Traversable[String] = Traversable("a", "b", "c", "d", "e")

    //when + then
    assertEquals(Traversable("a", "b", "c", "d", "e"), list.dropWhile((p: String) => false))
    assertEquals(Traversable(), list.dropWhile((p: String) => true))
    assertEquals(Traversable("d", "e"), list.dropWhile((p: String) => p < "d"))
  }

  @Test
  def filterTraversableTest() = {
    //given
    val list: Traversable[String] = Traversable("moscow", "warsaw", "berlin", "barcelona")

    //when
    val citiesStartWithB: Traversable[String] = list.filter((p: String) => p.startsWith("b"))

    //then
    assertEquals(Traversable("berlin", "barcelona"), citiesStartWithB)
  }

  @Test
  def filterNotTraversableTest() = {
    //given
    val list: Traversable[String] = Traversable("moscow", "warsaw", "berlin", "barcelona")

    //when
    val not: Traversable[String] = list.filterNot((p: String) => p.startsWith("b"))

    //then
    assertEquals(Traversable("moscow", "warsaw"), not)
  }

}
