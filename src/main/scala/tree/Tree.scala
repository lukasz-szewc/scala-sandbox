package tree

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class Tree(private var root: Option[Node] = Option.empty) {
  def add(number: Int): Unit = {
    val candidate: Node = new Node(number)
    if (root == Option.empty) {
      root = new Some[Node](candidate)
    } else {
      addNode(root.get, candidate)
    }
  }

  @tailrec
  private def addNode(node: Node, candidate: Node): Unit = {
    var nextNodeToCheck: Option[Node] = node.left
    if (node.nodeValue <= candidate.nodeValue) {
      if (node.right == Option.empty) {
        node.assignNodeRight(candidate)
        return
      } else {
        nextNodeToCheck = node.right
      }
    } else {
      if (node.left == Option.empty) {
        node.assignNodeLeftIfEmpty(candidate)
        return
      }
    }
    addNode(nextNodeToCheck.get, candidate)
  }

  @tailrec
  private def findNumber(numberToFind: Int, node: Node): Option[Node] = {
    var nextNodeCandidate: Option[Node] = node.left
    if (node.nodeValue == numberToFind) {
      return Some(node)
    } else if (node.nodeValue <= numberToFind) {
      if (node.right == Option.empty) {
        return Option.empty
      }
      nextNodeCandidate = node.right
    } else {
      if (node.left == Option.empty) {
        return Option.empty
      }
    }
    findNumber(numberToFind, nextNodeCandidate.get)
  }

  def find(numberToFind: Int): Option[Node] = {
    if (root == Option.empty) {
      return Option.empty
    }
    findNumber(numberToFind, root.get)
  }

  def postOrderTraverse(node: Node, ints: ListBuffer[Int]): ListBuffer[Int] = {
    if(node == null) {
      return ints
    }
    postOrderTraverse(node.left.orNull, ints)
    postOrderTraverse(node.right.orNull, ints)
    ints += node.nodeValue
  }

  def traversePostOrder(): ListBuffer[Int] = {
    postOrderTraverse(root.orNull, new ListBuffer[Int])
  }

  def traversePreOrder(): ListBuffer[Int] = {
    preOrderTraverse(root.orNull, new ListBuffer[Int])
  }

  def preOrderTraverse(node: Node, ints: ListBuffer[Int]): ListBuffer[Int] = {
    if(node == null) {
      return ints
    }
    ints += node.nodeValue
    preOrderTraverse(node.left.orNull, ints)
    preOrderTraverse(node.right.orNull, ints)
  }

  def traverseInOrder(): ListBuffer[Int] = {
    inOrderTraverse(root.orNull, new ListBuffer[Int])
  }

  def inOrderTraverse(node: Node, ints: ListBuffer[Int]): ListBuffer[Int] = {
    if (node == null) {
      return ints
    }

    inOrderTraverse(node.left.orNull, ints)
    ints += node.nodeValue
    inOrderTraverse(node.right.orNull, ints)
  }

  def traverseAndCount(): Int = {
    if (root == Option.empty) {
      return 0
    }
    visitNode(root.get, 1)
  }

  def visitNode(node: Node, acc: Int): Int = {
    if (node == null) {
      return acc
    }
    val leftValue: Int = visitNode(node.left.orNull, if (node.left != Option.empty) acc + 1 else acc)
    visitNode(node.right.orNull, if (node.right != Option.empty) leftValue + 1 else leftValue)
  }

  override def toString = s"Tree($root)"
}
