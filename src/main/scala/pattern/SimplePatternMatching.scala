package pattern


object SimplePatternMatching {
  def giveMeSubstitution(expr: Any) = expr match {
    case ("text", something) => something + "text"
  }

  def giveMeTuple(i: Int) = i match {
    case 1 => (1, 1 + i)
    case _ => 0
  }

  def giveMeValue(s: Int): String = s match {
    case 1 => "one"
    case _ => "other"
  }

}
