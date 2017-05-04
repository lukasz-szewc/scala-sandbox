package pattern

import java.time.OffsetDateTime

import org.hamcrest.CoreMatchers.is
import org.junit.Assert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

class SimplePatternMatchingTest {

  @Test def patterMatchForSimpleValueTest() {
    val value: String = SimplePatternMatching.giveMeValue(1)

    assertThat(value, is("one"))
  }

  @Test def patterMatchForOtherValueTest() {
    val value: String = SimplePatternMatching.giveMeValue(99)

    assertThat(value, is("other"))

  }

  @Test def patternForTuple() {
    val value = SimplePatternMatching.giveMeTuple(1)

    assertEquals(value, (1, 2))
  }

  @Test def patternForOtherTuple() {
    val value = SimplePatternMatching.giveMeTuple(91)

    assertEquals(value, 0)
  }

  @Test def substitutionPattern() {
    val value = SimplePatternMatching.giveMeSubstitution("text", 1)

    assertEquals(value, "1text")
  }

  @Test def otherSubstitutionPattern() {
    val value = SimplePatternMatching.giveMeSubstitution("text", 't')

    assertEquals(value, "ttext")
  }

  @Test def caseClassPatternMatching() = {
    val boss: Boss = Boss(1000)
    val employee: Employee = Employee(400, OffsetDateTime.now())
    
    assertEquals(salary(boss) - salary(employee), 1600, 0.000001d)
  }

  def salary(person: Person) = {
    person match {
      case Boss(salary) => salary * 2
      case Employee(salary, _) => salary
    }
  }
}
