package tree

class Tree(private var root: Option[Node] = Option.empty) {

  def add(number: Int): Unit = {
    val candidate: Node = new Node(number)
    if (root == Option.empty) {
      root = new Some[Node](candidate)
    } else {
      addNode(root.get, candidate)
    }
  }

  def addNode(node: Node, candidate: Node): Unit = {
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
  
  override def toString = s"Tree($root)"
}

object Tree{
  def main(args: Array[String]): Unit = {

    val someTree: Tree = new Tree()
    someTree.add(50)
    someTree.add(80)
    someTree.add(20)
    someTree.add(20)
    println("Hello, world! " + someTree)

  }
}
