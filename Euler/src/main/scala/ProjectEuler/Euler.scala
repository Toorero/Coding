package ProjectEuler

import scala.collection.mutable.Set

abstract protected class Euler(val nr: Int) {

  def solution: Any

  override def toString = s"Project Euler Nr.$nr: $solution)"

  def getUrl= s"https://projecteuler.net/index.php?section=problems&id=$nr"

  def register: Euler = { Euler.registeredProjects += this; this }

  Euler.registeredProjects += this
}

object Euler {
  val registeredProjects: Set[Euler] = Set[Euler]()

}
