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

  def print() = {
    MyStack.printStackValues(stack)
  }

}
object MyStack {
  def printStackValues(stack: mutable.Stack[Int]) = {
    val newBuilder: StringBuilder = mutable.StringBuilder.newBuilder
    newBuilder.append("[")
    val iterator: Iterator[Int] = stack.iterator
    while (iterator.hasNext) {
      newBuilder.append(iterator.next())
      if (iterator.hasNext) {
        newBuilder.append(", ")
      }
    }
    newBuilder.append("]")
    println(newBuilder.toString())
  }
}