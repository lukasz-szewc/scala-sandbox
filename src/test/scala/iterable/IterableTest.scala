package iterable

import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.junit.Test

class IterableTest {

  @Test
  def iteratorTests() = {
    //given
    val strings: Iterable[String] = Iterable("a", "b", "c")

    //when + then
    assertTrue(strings.iterator.contains("a"))
    assertFalse(strings.iterator.contains("z"))
    assertTrue(strings.iterator.exists((x: String) => x.equals("b")))
    assertFalse(strings.iterator.exists((x: String) => x.eq("Z")))

  }

  @Test
  def reverseIteratorTests() = {
    //given
    val strings = List("a", "b", "c").reverseIterator

    //when + then
    assertEquals("c", strings.next())
    assertEquals("b", strings.next())
    assertEquals("a", strings.next())
    assertEquals(false, strings.hasNext)
  }

  @Test
  def findMethodExample() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")
    val existElement = (x: String) => x.length == 1
    val doesNotExistElement = (x: String) => x.length == 100

    //when + then
    assertEquals("notThere", list.find(doesNotExistElement).getOrElse("notThere"))
    assertEquals("a", list.find(existElement).get)
    assertEquals("c", list.toList.reverseIterator.find(existElement).get)
  }

  @Test
  def groupByExample() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")

    //when
    val map: Map[Int, Traversable[String]] = list.groupBy((f: String) => f.length)

    //then
    assertEquals(1, map.size)
    assertEquals(list, map(1))
  }

  @Test
  def groupedIteratorTests() = {
    //given
    val strings: Iterable[String] = Iterable("a", "b", "c", "d", "e")

    //when
    val list: List[Iterable[String]] = strings.grouped(3).toList

    //then
    assertEquals(List("a", "b", "c"), list.head)
    assertEquals(List("d", "e"), list(1))

  }

  @Test
  def slidingIteratorTests() = {
    //given
    val strings: Iterable[String] = Iterable("a", "b", "c", "d", "e")

    //when
    val list = strings.sliding(2).toList

    //then
    assertEquals(4, list.size)
    assertEquals(List("a", "b"), list.head)
    assertEquals(List("b", "c"), list(1))
    assertEquals(List("c", "d"), list(2))
    assertEquals(List("d", "e"), list(3))

  }

  @Test
  def slidingStepIteratorTests() = {
    //given
    val strings = Iterable("a", "b", "c", "d", "e", "f", "g")

    //when
    val list = strings.sliding(4, 2).toList

    //then
    assertEquals(3, list.size)
    assertEquals(List("a", "b", "c", "d"), list.head)
    assertEquals(List("c", "d", "e", "f"), list(1))
    assertEquals(List("e", "f", "g"), list(2))

  }

  @Test
  def takeRightIteratorTests() = {
    //given
    val strings = Iterable("a", "b", "c", "d", "e", "f", "g")

    //when + then
    assertEquals(List("a", "b", "c"), strings.dropRight(4))
    assertEquals(List("e", "f", "g"), strings.takeRight(3))
  }

  @Test
  def someElementsIteratorTests() = {
    //given + when + then
    assertTrue(List("a", "b", "c") sameElements List("a", "b", "c"))
    assertFalse(List("b", "a", "c") sameElements List("a", "b", "c"))
  }

  @Test
  def zipIteratorTests() = {
    //given
    val left = List("a", "b", "c")
    val right = List(1, 2, 3)

    //when
    val tuples = left zip right

    //then
    assertEquals(("a", 1), tuples.head)
    assertEquals(("b", 2), tuples(1))
    assertEquals(("c", 3), tuples(2))
  }

  @Test
  def zipShortIteratorTests() = {
    //given
    val left = List("a", "b", "c")
    val right = List(1)

    //when
    val tuples = left.zipAll(right, "1", 8)

    //then
    assertEquals(("a", 1), tuples.head)
    assertEquals(("b", 8), tuples(1))
    assertEquals(("c", 8), tuples(2))
  }

  @Test
  def zipWithIndexIteratorTests() = {
    //given
    val left = List("a", "b", "c")

    //when
    val index = left.zipWithIndex

    //then
    assertEquals(("a", 0), index.head)
    assertEquals(("b", 1), index(1))
    assertEquals(("c", 2), index(2))
  }
}
