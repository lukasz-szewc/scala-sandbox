package traversable

import java.util

import org.junit.Assert._
import org.junit.Test

class TraversableGenericTest {

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

}
