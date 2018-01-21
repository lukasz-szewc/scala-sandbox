package org.sandbox

import org.junit.Assert.assertEquals
import org.junit.Test

class RecursiveFunctionsTest {

  @Test
  def fibonacciTest(): Unit = {
    assertEquals(8, RecursiveFunctions.fibonacci(6))
    assertEquals(13, RecursiveFunctions.fibonacci(7))
    assertEquals(21, RecursiveFunctions.fibonacci(8))
  }

  @Test
  def factorialTest(): Unit = {
    assertEquals(1, RecursiveFunctions.factorial(0))
    assertEquals(1, RecursiveFunctions.factorial(1))
    assertEquals(2, RecursiveFunctions.factorial(2))
    assertEquals(6, RecursiveFunctions.factorial(3))
    assertEquals(24, RecursiveFunctions.factorial(4))
    assertEquals(120, RecursiveFunctions.factorial(5))
  }

}
