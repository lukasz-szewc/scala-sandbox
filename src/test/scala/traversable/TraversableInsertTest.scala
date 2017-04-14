package traversable

import org.junit.Assert._
import org.junit.Test

class TraversableInsertTest {

  @Test
  def traversablesCanBeAdded() = {
    //given
    val first = Traversable("1", "2")
    val second = Traversable("3", "4")

    // when + then
    assertEquals(second.++(first), Traversable("3", "4", "1", "2"))
  }

  @Test
  def cannotBelieveThisIsLegalInThisHorribleLanguage() = {
    //given
    val ++ = Traversable("1", "2")
    val +++ = Traversable("3", "4")

    // when + then
    assertEquals(++ ++ +++, Traversable("1", "2", "3", "4"))
  }
}
