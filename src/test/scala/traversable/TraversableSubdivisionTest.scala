package traversable

import org.junit.Assert.assertEquals
import org.junit.Test

class TraversableSubdivisionTest {

  @Test
  def splitAtTraversableTest() = {
    //given
    val traversable: Traversable[String] = Traversable("moscow", "warsaw", "berlin", "barcelona")

    //when
    val split: (Traversable[String], Traversable[String]) = traversable.splitAt(2)

    //then
    assertEquals(Traversable("moscow", "warsaw"), split._1)
    assertEquals(Traversable("berlin", "barcelona"), split._2)
  }

  @Test
  def splitAtZeroTraversableTest() = {
    //given
    val traversable: Traversable[String] = Traversable("moscow", "warsaw", "berlin", "barcelona")

    //when
    val split = traversable.splitAt(0)

    //then
    assertEquals(Traversable(), split._1)
    assertEquals(traversable, split._2)
  }

  @Test
  def spanTraversableTest() = {
    //given
    val traversable: Traversable[Int] = Traversable(1, 2, 3 ,4, 5)

    //when
    val span = traversable.span((p: Int) => p <= 2)

    //then
    assertEquals(Traversable(1, 2), span._1)
    assertEquals(Traversable(3, 4, 5), span._2)
  }

  @Test
  def partitionTraversableTest() = {
    //given
    val traversable: Traversable[Int] = Traversable(1, 2, 3 ,4, 5)

    //when
    val span = traversable.partition((p: Int) => p == 2)

    //then
    assertEquals(Traversable(2), span._1)
    assertEquals(Traversable(1, 3, 4, 5), span._2)
  }

  @Test
  def groupByTraversableTest() = {
    //given
    val traversable = Traversable("moscow", "warsaw", "berlin", "barcelona")

    //when
    val f = (p: String) => if (p.length <= 6) "shortName" else "longName"
    val map: Map[String, Traversable[String]] = traversable.groupBy(f)

    //then
    assertEquals(Traversable("moscow", "warsaw", "berlin"), map("shortName"))
    assertEquals(Traversable("barcelona"), map("longName"))
  }

}
