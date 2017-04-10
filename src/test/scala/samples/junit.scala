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
    val foo: String = App.foo(x.toArray)
    println(foo)
  }

}


