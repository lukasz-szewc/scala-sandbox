package traversable

import org.junit.Assert.assertEquals
import org.junit.Test

class TraversableSpecificFoldTest {
  
  @Test
  def filterNotTraversableTest() = {
    //given
    val traversable: Traversable[Int] = Traversable(1, 2, 3, 4)

    //when
    val sum: Int = traversable.sum

    //then
    assertEquals(10, sum)
  }

}
