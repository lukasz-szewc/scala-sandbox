package traversable

import org.junit.Assert.assertEquals
import org.junit.Test

import scala.collection.mutable.ArrayBuffer

class TraversableFoldTest {

  @Test
  def foldLeftTest() = {
    //given
    val list: Traversable[Int] = List(1, 2, 3, 4)
    val op: (Int, Int) => Int = (x, y) => x + y

    //when + then
    assertEquals(0, list.foldLeft(-10)(op))
    assertEquals(10, (0 /: list)(op))
    assertEquals(20, list.foldLeft(10)(_ + _))
    assertEquals(20, list.fold(10)(_ + _))
  }

  @Test
  def reduceTest() = {
    //given
    val list: Traversable[Int] = List(1, 2, 3, 4)
    val op = (x: Int, y: Int) => x + y

    //when + then
    assertEquals(10, list.reduceLeft(op))
    assertEquals(10, list.reduceRight(op))
    assertEquals(10, list.reduce(op))
  }

}
