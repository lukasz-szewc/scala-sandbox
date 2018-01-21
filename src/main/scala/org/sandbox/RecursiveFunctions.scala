package org.sandbox

import scala.annotation.tailrec

object RecursiveFunctions {

  def factorial(i: Int): Int = {
    def tailRecursiveFactorial(aggregate: Int, counter: Int): Int = {
      counter match {
        case 0 => 1
        case 1 => aggregate
        case _ => tailRecursiveFactorial(aggregate * counter, counter - 1)
      }

    }
    tailRecursiveFactorial(1, i)
  }

  def fibonacci(nr: Long): Long = {
    @tailrec
    def tailRecursiveFibonacci(previous: Long, current: Long, counter: Long): Long = {
      counter match {
        case 0 => 0
        case 1 => current
        case _ => tailRecursiveFibonacci(current, previous + current, counter - 1)
      }
    }
    tailRecursiveFibonacci(0, 1, nr)
  }

}
