package samples

import org.junit._
import Assert._
import org.sandbox.App

@Test
class AppTest {

  @Test
  def testOK() = assertTrue(true)

  @Test
  def testKO() = {
    val x: List[String] = "ABC" :: "ADE" :: "DEF" :: Nil
    val toArray: Array[String] = x.toArray
    val foo: String = App.foo(toArray)
    val main: Unit = App.main(toArray)
    println(foo)
  }

}


