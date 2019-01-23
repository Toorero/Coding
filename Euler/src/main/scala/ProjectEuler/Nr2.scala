package ProjectEuler

object Nr2 extends Euler(2){

  private def fibonacci(a: Int, b: Int): Stream[Int] = a #:: fibonacci(b, a + b)
  private def even(i: Int) = i % 2 == 0

  lazy val fibonacci: Stream[Int] = fibonacci(1,1)

  lazy val evenFibonacci: Stream[Int] = fibonacci filter even

  def solution: Any = evenFibonacci takeWhile (_ < 4000000) sum
}
