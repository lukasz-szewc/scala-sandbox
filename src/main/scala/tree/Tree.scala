package tree

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.util.Random

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
  private def findNumber(numberToFind: Int, node: Node): Boolean = {
    var nextNodeCandidate: Option[Node] = node.left
    if (node.nodeValue == numberToFind) {
      return true
    } else if (node.nodeValue <= numberToFind) {
      if (node.right == Option.empty) {
        return false
      }
      nextNodeCandidate = node.right
    } else {
      if (node.left == Option.empty) {
        return false
      }
    }
    findNumber(numberToFind, nextNodeCandidate.get)
  }

  def find(numberToFind: Int): Boolean = {
    if (root == Option.empty) {
      return false
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

  def postOrderTraverseTree(): ListBuffer[Int] = {
    postOrderTraverse(root.orNull, new ListBuffer[Int])
  }

  def preOrderTraverseTree(): ListBuffer[Int] = {
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

  def inOrderTraverseTree(): ListBuffer[Int] = {
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

  def traverseTree(): Int = {
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

object Tree{
  def main(args: Array[String]): Unit = {

    val someTree: Tree = new Tree()
    someTree.add(50)
    someTree.add(80)
    someTree.add(20)
    someTree.add(20)
    someTree.add(60)
    println("Hello, world! " + someTree)

    println(someTree.find(50))
    println(someTree.find(80))
    println(someTree.find(20))
    println(someTree.find(60))
    println(someTree.find(61))
    println(someTree.find(0))

    println(new Tree().traverseTree())
    println(new Tree(Some(new Node(10))).traverseTree())
    val tree: Tree = new Tree()
    tree.add(1)
    tree.add(10)
    tree.add(12)
    tree.add(33)
    println(tree.traverseTree())
    println(someTree.traverseTree())

    val anotherTree: Tree = new Tree()
    val random: Random = new Random()
    for (x <- 1 to 10000 ) {
      anotherTree.add(random.nextInt(100000))
    }
    println(anotherTree.traverseTree())
  }
}
