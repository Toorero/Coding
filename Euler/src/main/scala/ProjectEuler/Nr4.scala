package ProjectEuler
import languageFeature.postfixOps

object Nr4 extends Euler(4) {

  def isPalindromic(x: Int): Boolean = {
    val str = x.toString
    val (first, second) = str.splitAt(str.length / 2)

    if (str.length % 2 == 0) first == second.reverse
    else first == second.drop(1).reverse
  }

  def digitNumberStream(n: Int) = Stream.from(Math.pow(10,n - 1) toInt).take(9 * Math.pow(10, n -1).toInt)

  val numberStream3 = digitNumberStream(3)

  val all3DigitPalindromicNumbers: Stream[Int] = for{
    a <- numberStream3
    b <- numberStream3

    if b<=a

    product = a * b if isPalindromic(product)
  } yield product

  def solution: Any = all3DigitPalindromicNumbers.max
}
