package traversable

import java.util.NoSuchElementException

import org.junit.Assert.assertEquals
import org.junit.Test

class TraversableHeadLastTest {

  @Test(expected = classOf[NoSuchElementException])
  def nilTraversableHead() = {
    //given + when + then
    val head = Nil.head
  }

  @Test(expected = classOf[NoSuchElementException])
  def nilTraversableLast() = {
    //given + when + then
    val last = Nil.last
  }

  @Test(expected = classOf[NoSuchElementException])
  def emptyTraversableHead() = {
    //given + when + then
    val head = Traversable().head
  }

  @Test(expected = classOf[NoSuchElementException])
  def emptyTraversableLast() = {
    //given + when + then
    val last = Traversable().last
  }

  @Test
  def headOptionForNilTraversable() = {
    //given + when + then
    assertEquals("x", Nil.headOption.getOrElse("x"))
    assertEquals("x", Nil.lastOption.getOrElse("x"))
  }

  @Test
  def headOptionForEmptyTraversable() = {
    //given + when + then
    assertEquals("x", Traversable().headOption.getOrElse("x"))
    assertEquals("x", Traversable().lastOption.getOrElse("x"))
  }

  @Test
  def ordinaryTraversableTest() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")

    //when + then
    assertEquals("a", list.head)
    assertEquals("c", list.last)
    assertEquals("a", list.headOption.getOrElse("x"))
    assertEquals("c", list.lastOption.getOrElse("x"))
  }

  @Test
  def oneElementTraversableTest() = {
    //given
    val list: Traversable[String] = List("a")

    //when + then
    assertEquals("a", list.head)
    assertEquals("a", list.last)
  }

  @Test
  def findMethodTest() = {
    //given
    val intTraversable = Traversable(1, 2, 3, 4, 1, 2)

    //when
    val find: Option[Int] = intTraversable.find((p: Int) => p > 3)
    val notFind: Option[Int] = intTraversable.find((p: Int) => p > 4)

    //then
    assertEquals(4, find.getOrElse(99))
    assertEquals(None, notFind)
    assertEquals(99, notFind.getOrElse(99))
  }
}
