package traversable

import org.junit.Assert.assertEquals
import org.junit.Test

class TraversableSpecificFoldTest {
  
  @Test
  def sumTraversableTest() = {
    //given
    val traversable: Traversable[Int] = Traversable(1, 2, 3, 4)

    //when
    val sum: Int = traversable.sum

    //then
    assertEquals(10, sum)
  }

  @Test
  def productTraversableTest() = {
    //given
    val traversable: Traversable[Int] = Traversable(2, 6, 10)

    //when
    val product: Int = traversable.product

    //then
    assertEquals(120, product)
  }

  @Test
  def minMaxTraversableTest() = {
    //given
    val traversable: Traversable[Int] = Traversable(9, 6, 7, 3)

    //when + then
    assertEquals(3, traversable.min)
    assertEquals(9, traversable.max)
  }

  @Test
  def minByMaxTraversableTest() = {
    //given
    val traversable: Traversable[Int] = Traversable(-2, -1, 0, 1, 2)

    //when + then
    assertEquals(0, traversable.minBy((f: Int) => Math.abs(f)))
  }

}
