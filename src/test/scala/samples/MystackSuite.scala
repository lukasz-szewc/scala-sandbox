package samples

import org.junit.Test
import org.sandbox.MyStack
import org.scalatest.Assertions


class MystackSuite extends Assertions {

  @Test def stackShouldPopValuesIinLastInFirstOutOrder() {
    val stack = new MyStack
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }
}
