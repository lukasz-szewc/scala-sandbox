package traversable

import org.junit.Assert.assertEquals
import org.junit.Test

import scala.collection.mutable.ArrayBuffer

class TraversableStringTest {

  @Test
  def stringPrefixTraversableTest() = {
    //given + when + then
    assertEquals("List", List().stringPrefix)
    assertEquals("Set", Set().stringPrefix)
    assertEquals("Map", Map().stringPrefix)
    assertEquals("ArrayBuffer", new ArrayBuffer[String]().stringPrefix)
  }

  @Test
  def stringAddStringTraversableTest() = {
    //given 
    val list: List[String] = List("abc", "def")

    //when + then
    assertEquals("abcdef", list.addString(new StringBuilder).toString())
    assertEquals("abc---def", list.addString(new StringBuilder, "---").toString())
    assertEquals("!abc-def#", list.addString(new StringBuilder,"!", "-", "#").toString())
  }
}
