package org.sandbox

import scala.collection.mutable

class MyStack {
  val stack: mutable.Stack[Int] = new mutable.Stack[Int]

  def pop() = {
    stack.pop()
  }

  def push(i: Int) = {
    stack.push(i)
  }

  def isEmpty = {
    stack.isEmpty
  }

}
