package tree

import org.junit.Assert._
import org.junit.Test

class TreeTest {

  @Test
  def emptyTreeTest(): Unit = {
    //given
    val tree: Tree = new Tree()

    //when
    val nodesVisited: Int = tree.traverseAndCount()

    //then
    assertEquals(0, nodesVisited)
  }

  @Test
  def oneElementTreeTest(): Unit = {
    //given
    val tree: Tree = new Tree(new Some[Node](new Node(50)))

    //when
    val nodesVisited: Int = tree.traverseAndCount()

    //then
    assertEquals(1, nodesVisited)
  }

  @Test
  def threeElementTreeTraverseTest(): Unit = {
    //given
    val tree: Tree = complexBalancedTree

    //when
    val nodesVisited: Int = tree.traverseAndCount()

    //then
    assertEquals(7, nodesVisited)
  }

  @Test
  def findTest(): Unit = {
    //given
    val tree: Tree = new Tree(new Some[Node](new Node(50)))

    //when
    val firstElement = tree.find(10)
    val secondElement = tree.find(50)

    //then
    assertEquals(false, firstElement.isDefined)
    assertEquals(true, secondElement.isDefined)
  }

  @Test
  def findMoreComplexTest(): Unit = {
    //given
    val tree: Tree = complexBalancedTree

    //when + then
    assertEquals(true, tree.find(10).isDefined)
    assertEquals(true, tree.find(20).isDefined)
    assertEquals(true, tree.find(30).isDefined)
    assertEquals(true, tree.find(50).isDefined)
    assertEquals(true, tree.find(70).isDefined)
    assertEquals(true, tree.find(90).isDefined)
  }

  @Test
  def verifyToStringTest(): Unit = {
    //given
    val tree: Tree = complexBalancedTree

    //when + then
    assertNotNull(tree.toString)
  }

  @Test
  def inOrderTraverseTest(): Unit = {
    //given
    val tree: Tree = complexBalancedTree

    //when
    val ints = tree.traverseInOrder()

    //then
    assertEquals(List(10, 20, 30, 50, 70, 80 , 90), ints.toList)
  }

  @Test
  def inOrderTraverseEmptyTreeTest(): Unit = {
    //given
    val tree: Tree = new Tree()

    //when
    val ints = tree.traverseInOrder()

    //then
    assertEquals(List(), ints.toList)
  }

  @Test
  def preOrderTraverseTest(): Unit = {
    //given
    val tree: Tree = complexBalancedTree

    //when
    val ints = tree.traversePreOrder()

    //then
    assertEquals(List(50, 20, 10, 30, 80, 70 , 90), ints.toList)
  }

  @Test
  def preOrderTraverseEmptyTreeTest(): Unit = {
    //given
    val tree: Tree = new Tree()

    //when
    val ints = tree.traversePreOrder()

    //then
    assertEquals(List(), ints.toList)
  }

  @Test
  def postOrderTraverseTest(): Unit = {
    //given
    val tree: Tree = complexBalancedTree

    //when
    val ints = tree.traversePostOrder()

    //then
    assertEquals(List(10, 30, 20, 70, 90, 80 , 50), ints.toList)
  }

  @Test
  def postOrderTraverseEmptyTreeTest(): Unit = {
    //given
    val tree: Tree = new Tree()

    //when
    val ints = tree.traversePostOrder()

    //then
    assertEquals(List(), ints.toList)
  }

  def complexBalancedTree: Tree = {
    val tree: Tree = new Tree(new Some[Node](new Node(50)))
    tree.add(20)
    tree.add(80)
    tree.add(10)
    tree.add(30)
    tree.add(70)
    tree.add(90)
    tree
  }

}
