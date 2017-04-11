package samples

import org.junit.Assert._
import org.junit.Test

class TraversableTest {

  @Test
  def collectionsCanBeAdded() = {
    val firstList: Traversable[String] = List("abc", "cde")
    val secondList: Traversable[String] = List("fgh", "ijk")
    val strings: Traversable[String] = firstList ++ secondList

    assertEquals(4, strings.size)
  }

  @Test
  def whenAddedMustBeWrappedWithOtherCollection() = {
    val firstList: Traversable[Double] = List(2.0, 3.0)
    val secondList: Traversable[Double] = firstList.++(4.0 :: Nil)
    val thirdList: Traversable[Double] = secondList ++ List(5.0)

    assertEquals(4, thirdList.size)
  }

  @Test
  def listCanBeConvertedToArray() = {
    val array: Array[String] = List("a", "b", "c").toArray

    assertEquals(3, array.length)
    assertEquals("a", array(0))
    assertEquals("b", array(1))
    assertEquals("c", array(2))
  }

  @Test
  def iteratorTests() = {
    assertTrue(List("a", "b", "c").iterator.contains("a"))
    assertFalse(List("a", "b", "c").iterator.contains("z"))

    assertTrue(List("a", "b", "c").iterator.exists((x: String) => x.equals("b")))
    assertFalse(List("a", "b", "c").iterator.exists((x: String) => x.eq("Z")))

  }

  @Test
  def reverseIteratorTests() = {
    val strings = List("a", "b", "c").reverseIterator
    assertEquals("c", strings.next())
    assertEquals("b", strings.next)
    assertEquals("a", strings.next)
    assertEquals(false, strings.hasNext)
  }

  @Test
  def copyToArrayTest() = {
    val list: List[String] = List("a", "b", "c")
    val destination = new Array[String](3)
    list.copyToArray(destination)

    assertEquals("a", destination(0))
    assertEquals("b", destination(1))
    assertEquals("c", destination(2))
  }

  @Test
  def headAndTailsTest() = {
    val list: List[String] = List("a", "b", "c")

    assertEquals("a", list.head)
    assertEquals(List("b", "c"), list.tail)
    assertEquals("a", list.headOption.get)
    assertEquals(List("a", "b"), list.slice(0, 2))
  }

  @Test
  def takeMethodTest() = {
    val list: List[String] = List("a", "b", "c")

    assertEquals(Nil, list.take(0))
    assertEquals(List("a"), list.take(1))
    assertEquals(List("a", "b"), list.take(2))
    assertEquals(List("a", "b", "c"), list.take(3))
  }

  @Test
  def findMethodExample() = {
    val list: List[String] = List("a", "b", "c")
    val existElement = (x: String) => x.length == 1
    val doesNotExistElement = (x: String) => x.length == 100

    assertEquals("notThere", list.find(doesNotExistElement).getOrElse("notThere"))
    assertEquals("a", list.find(existElement).get)
    assertEquals("c", list.reverseIterator.find(existElement).get)
  }

}
