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

}
