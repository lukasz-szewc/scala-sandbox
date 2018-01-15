package tree

class Node(val nodeValue: Int) {
  var left: Option[Node] = Option.empty
  var right: Option[Node] = Option.empty
  def assignNodeRight(candidate: Node): Unit = {
    if (right == Option.empty) {
      right = Some[Node](candidate)
    }
  }
  def assignNodeLeftIfEmpty(candidate: Node): Unit = {
    if (left == Option.empty) {
      left = Some[Node](candidate)
    }
  }
  override def toString = s"root($nodeValue) - left($left) - right($right)"
}
