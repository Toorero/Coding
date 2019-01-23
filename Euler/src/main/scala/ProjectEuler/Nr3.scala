package ProjectEuler

object Nr3 extends Euler(3){
  val x = BigInt("600851475143")

  def sqt(n:BigInt) :BigDecimal = {
    val d = BigDecimal(n)
    var a = BigDecimal(1.0)
    var b = d
    while(b-a >= 0) {
      val mid = (a+b)/2
      if (mid*mid-d > 0) b = mid-0.0001  //adjust down
      else               a = mid+0.0001  //adjust up
    }
    b
  }


  def factors(x: BigInt): Seq[Int] = {
    // Sieving integral numbers
    def sieve(s: Stream[Int]): Stream[Int] = {
      s.head #:: sieve(s.tail.filter(_ % s.head != 0))
    }

    // All primes as a lazy sequence
    val primes = sieve(Stream.from(2)).take(sqt(x).toInt)

    val factor: Option[Int] = primes.find(x % _ == 0)

    factor match {
      case None => Seq(x.toInt)
      case Some(i) => Seq(i) ++ factors(x / i)
    }

  }

  println(factors(25))

  def solution: Any = factors(x).last
}
