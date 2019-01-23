package ProjectEuler

object Nr12 extends Euler(12){

  val divisorC = 500

  def trainglestream = Stream.from(1).scan(0)(_ + _)

  def getDivisor(n: Int) = {
    val middleFactor = math.sqrt(n).intValue
    val smallFactors = (1 to middleFactor).count(n % _ == 0)
    2 * smallFactors - (if (middleFactor * middleFactor == n) 1 else 0)
  }

  override def solution: Any = trainglestream.dropWhile(getDivisor(_) < 500).head


}
