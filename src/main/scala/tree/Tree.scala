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
    def candidate = {
      if (node.nodeValue <= numberToFind) node.right else node.left
    }

    def safeValueOfNode = if (node != null) node.nodeValue else null

    safeValueOfNode match {
      case null => None
      case `numberToFind` => Some(node)
      case _ => findNumber(numberToFind, candidate.orNull)
    }
  }

  def removeNode(i: Int): Option[Node] = {
    if (root == None) removeRootNodeAndReturn(root) else removeNode(i, root, None)
  }

  def removeNode(i: Int, node: Option[Node], root: Option[Node]): Option[Node] = {
    def candidate = {
      val value = node.get
      if (value.nodeValue <= i) value.right else value.left
    }
    def value = if (node != Option.empty) node.get.nodeValue else null
    value match {
      case null => node
      case `i` => if (root == Option.empty) removeRootNodeAndReturn(root) else root.get.remove(node)
      case _ => removeNode(i, candidate, node)
    }
  }

  private def removeRootNodeAndReturn(root: Option[Node]): Option[Node] = {
    val toReturn = this.root
    this.root = root
    toReturn
  }

  def find(numberToFind: Int): Option[Node] = {
    root match {
      case None => Option.empty
      case Some(_) => findNumber(numberToFind, root.get)
    }
  }

  def postOrderTraverse(node: Node, ints: ListBuffer[Int]): ListBuffer[Int] = {
    def actualPostOrderTraverse = {
      postOrderTraverse(node.left.orNull, ints)
      postOrderTraverse(node.right.orNull, ints)
      ints += node.nodeValue
    }

    node match {
      case null => ints
      case _ => actualPostOrderTraverse
    }
  }

  def traversePostOrder(): ListBuffer[Int] = {
    postOrderTraverse(root.orNull, new ListBuffer[Int])
  }

  def traversePreOrder(): ListBuffer[Int] = {
    preOrderTraverse(root.orNull, new ListBuffer[Int])
  }

  def preOrderTraverse(node: Node, ints: ListBuffer[Int]): ListBuffer[Int] = {
    def actualPreOrderTraversal: ListBuffer[Int] = {
      ints += node.nodeValue
      preOrderTraverse(node.left.orNull, ints)
      preOrderTraverse(node.right.orNull, ints)
    }
    node match {
      case null => ints
      case _ => actualPreOrderTraversal
    }
  }

  def traverseInOrder(): ListBuffer[Int] = {
    inOrderTraverse(root.orNull, new ListBuffer[Int])
  }

  def inOrderTraverse(node: Node, ints: ListBuffer[Int]): ListBuffer[Int] = {
    def actualInOrderTraverse = {
      inOrderTraverse(node.left.orNull, ints)
      ints += node.nodeValue
      inOrderTraverse(node.right.orNull, ints)
    }

    node match {
      case null => ints
      case _ => actualInOrderTraverse
    }
  }

  def traverseAndCount(): Int = {
    root match {
      case None => 0
      case Some(_) => visitNode(root.get, 1)
    }
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