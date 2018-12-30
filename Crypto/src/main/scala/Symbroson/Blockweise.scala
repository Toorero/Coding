package Symbroson


object Blockweise{

  def crypt(s: String, key: Array[Int]) = {

    var buf1, buf2, len1, len2: Int = 0

    for (c <- s) {
      buf1 <<= 8 //um 8 Bits nach Rechts verschieben um für neue Bits platz zu machen
      len1 += 8

      buf1 += c.toInt //8 Bits hinzufügen


      while (len1 >= 3) { //Dreiergruppen auslesen
        len1 -= 3
        len2 += 3
        buf2 <<= 3 //Platz für Drei Bits machen

        buf2 += key((buf1 >> len1) % (1 << 3))
      }

      while (len2 >= 8) {
        len2 -= 8

        printf("%4d: %c%n", buf2 >> len2, buf2 >> len2)

        buf2 %= 1 << len2
      }
    }

    if (len2 > 0)
      printf("%4d: %c%n", (buf2 << (8 - len2)) + buf1 % (1 << len1), (buf2 << (8 - len2)) + buf1 % (1 << len1))

  }

  def defkey = Array[Int](1, 6, 0, 7, 3, 4, 2, 5)


}
