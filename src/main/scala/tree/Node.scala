package tree

class Node(val nodeValue: Int) {
  var left: Option[Node] = Option.empty
  var right: Option[Node] = Option.empty
  def assignNodeRight(candidate: Node) = right = Some[Node](candidate)
  def assignNodeLeft(candidate: Node): Unit = left = Some[Node](candidate)
  override def toString = s"root($nodeValue) - left($left) - right($right)"
}
