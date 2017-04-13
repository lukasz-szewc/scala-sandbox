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

}
