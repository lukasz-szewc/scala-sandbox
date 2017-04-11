package samples

import java.util

import org.junit.Assert._
import org.junit.Test

class TraversableTest {

  @Test
  def createdJustByTraversable() = {
    //given
    val strings: Traversable[String] = Traversable("abc", "cde", "fgh")

    //then
    assertEquals(3, strings.size)
  }

  @Test
  def forEachTest() = {
    //given
    val destinationList: util.ArrayList[String] = new util.ArrayList[String]()
    val strings: Traversable[String] = Traversable("abc", "cde", "fgh")

    //when
    strings.foreach((f: String) => destinationList.add(f.toUpperCase))

    //then
    assertEquals(3, destinationList.size)
    assertEquals("ABC", destinationList.get(0))
  }

  @Test
  def collectionsCanBeAdded() = {
    //given
    val firstList: Traversable[String] = List("abc", "cde")
    val secondList: Traversable[String] = List("fgh", "ijk")

    //when
    val strings: Traversable[String] = firstList ++ secondList

    //then
    assertEquals(4, strings.size)
  }

  @Test
  def whenAddedMustBeWrappedWithOtherCollection() = {
    //given
    val firstList: Traversable[Double] = List(2.0, 3.0)

    //when
    val secondList: Traversable[Double] = firstList.++(4.0 :: Nil)
    val thirdList: Traversable[Double] = secondList ++ List(5.0)

    //then
    assertEquals(4, thirdList.size)
  }

  @Test
  def listCanBeConvertedToArray() = {
    //given
    val array: Array[String] = List("a", "b", "c").toArray

    //when + then
    assertEquals(3, array.length)
    assertEquals("a", array(0))
    assertEquals("b", array(1))
    assertEquals("c", array(2))
  }

  @Test
  def iteratorTests() = {
    //given
    val strings: List[String] = List("a", "b", "c")

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
  def copyToArrayTest() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")
    val destination = new Array[String](3)

    //when
    list.copyToArray(destination)

    //then
    assertEquals("a", destination(0))
    assertEquals("b", destination(1))
    assertEquals("c", destination(2))
  }

  @Test
  def headAndTailsTest() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")

    //when + then
    assertEquals("a", list.head)
    assertEquals(List("b", "c"), list.tail)
    assertEquals("a", list.headOption.get)
    assertEquals(List("a", "b"), list.slice(0, 2))
  }

  @Test
  def takeMethodTest() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")

    //when + then
    assertEquals(Nil, list.take(0))
    assertEquals(List("a"), list.take(1))
    assertEquals(List("a", "b"), list.take(2))
    assertEquals(List("a", "b", "c"), list.take(3))
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
  def groupByExample() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")

    //when
    val map: Map[Int, Traversable[String]] = list.groupBy((f: String) => f.length)

    //then
    assertEquals(1, map.size)
    assertEquals(list, map.get(1).get)
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
