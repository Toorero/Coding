package ProjectEuler

object Nr1 extends Euler(1){


  def solution: Any = {
    val stream5 = Stream.from(5,5).takeWhile( _ < 1000)
    val stream3 = Stream.from(3,3).takeWhile(_ < 1000)

    val x = (stream5 #::: stream3).groupBy(identity)

    x.foldRight(0)( (x, acc) => acc + x._1)
  }
}
