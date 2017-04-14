package traversable

import org.junit.Assert.assertEquals
import org.junit.Test

import scala.collection.mutable.ArrayBuffer

class TraversableCopyTest {

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
    assertEquals(3, destination.length)
  }

  @Test
  def copyToBufferTest() = {
    //given
    val list: Traversable[String] = List("a", "b", "c")
    val destination: ArrayBuffer[String] = new ArrayBuffer[String]()

    //when
    list.copyToBuffer(destination)

    //then
    assertEquals("a", destination(0))
    assertEquals("b", destination(1))
    assertEquals("c", destination(2))
    assertEquals(3, destination.length)
  }


}
