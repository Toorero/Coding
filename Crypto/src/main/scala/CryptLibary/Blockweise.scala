package CryptLibary

object Blockweise {

  def crypt(s: String)(key: Int => Int) = {
    val bits = s.map(s => toBinaryString(s.toInt, 8)).foldLeft("")(_ + _)

    val grouped = bits grouped 3 toList

    val (blocks, überschuss) = if (grouped.last.length < 3) (grouped dropRight 1, Some(grouped.last)) else (grouped dropRight 1, None)

    val cryptedbits: String = blocks.map(s => Integer.parseInt(s, 2)) // Verwandelt 3 Bitblocks in Integers
      .map(i => key(i)) // Wendet Schlüsselfkt. an
      .map(s => toBinaryString(s, 3)).foldLeft("")(_ + _) // Wandelt Integers Bitfolge um

    val newbits = überschuss match {
      case Some(ü: String) => cryptedbits + ü
      case _ => cryptedbits
    }


    newbits.grouped(8).map(s => Integer.parseInt(s, 2).toChar).foldLeft("")(_ + _)
  }

  def genKey(k: Array[Int]): Int => Int = {
    require(k.length == 8)
    i: Int => k(i)
  }

  def genKey(s: String): Int => Int = genKey(s.map(_ toInt).toArray)

  val encryptionKey: Function[Int, Int] = genKey(Array(1, 6, 0, 7, 3, 4, 2, 5))
  val decryptionKey: Function[Int, Int] = genKey(Array(2, 0, 6, 4, 5, 7, 1, 3))


  def toBinaryString(i: Int, n: Int) = String.format("%" + n + "s", i.toBinaryString).replace(" ", "0")

}
