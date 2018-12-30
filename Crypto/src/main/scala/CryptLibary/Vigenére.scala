package CryptLibary

object Vigenére {
  // a..z => 97..122

  def encrypt(key: String, message: String): String = crypt(key.map(_.toInt - 97), message).mkString

  def decrypt(key: String, message: String): String = crypt(key.map(97 - _.toInt), message).mkString


  private def offsetChar(c: Char, i: Int): Char = {
    require(
      (c >= 'a' && c <= 'z') || c == ' ',
      "Es sind nur kleine Buchstaben von a bis z und Leerzeichen erlaubt!"
    )

    if (c == ' ') c else {
      var newInt = c + i

      //Über Wertebereich hinaus versetzt?
      if (newInt > 122) newInt -= 26
      else if (newInt < 97) newInt += 26
      newInt.toChar
    }

  }

  private def crypt(key: IndexedSeq[Int], message: String) = for {
    (c, i) <- message.zipWithIndex
    k = i % (key length)
  } yield offsetChar(c, key(k))
}
