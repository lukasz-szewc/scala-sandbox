package tree

import org.junit.Assert._
import org.junit.Test

class TreeTest {

  @Test
  def emptyTreeTest() = {
    //given
    val tree: Tree = new Tree()

    //when
    val nodesVisited: Int = tree.traverseTree()

    //then
    assertEquals(0, nodesVisited)
  }

  @Test
  def oneElementTreeTest() = {
    //given
    val tree: Tree = new Tree(new Some[Node](new Node(50)))

    //when
    val nodesVisited: Int = tree.traverseTree()

    //then
    assertEquals(1, nodesVisited)
  }
  
  @Test
  def threeElementTreeTraverseTest() = {
    //given
    val tree: Tree = complexBalancedTree

    //when
    val nodesVisited: Int = tree.traverseTree()

    //then
    assertEquals(7, nodesVisited)
  }

  @Test
  def findTest() = {
    //given
    val tree: Tree = new Tree(new Some[Node](new Node(50)))

    //when
    val firstElement: Boolean = tree.find(10)
    val secondElement: Boolean = tree.find(50)

    //then
    assertEquals(false, firstElement)
    assertEquals(true, secondElement)
  }

  @Test
  def findMoreComplexTest() = {
    //given
    val tree: Tree = complexBalancedTree

    //when + then
    assertEquals(true, tree.find(10))
    assertEquals(true, tree.find(20))
    assertEquals(true, tree.find(30))
    assertEquals(true, tree.find(50))
    assertEquals(true, tree.find(70))
    assertEquals(true, tree.find(90))
  }

  @Test
  def verifyToStringTest() = {
    //given
    val tree: Tree = complexBalancedTree

    //when + then
    assertNotNull(tree.toString)
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
