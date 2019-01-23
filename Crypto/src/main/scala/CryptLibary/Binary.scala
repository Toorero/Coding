package CryptLibary

object Binary {

  def crypt(key: String, message: String): String = {
    val keyi = Integer.parseInt(key, 2)

    for (c <- message) yield (c ^ keyi).toChar
  }

  def crypt2(key: String, message: String): String = {
    val keyi = Integer.parseInt(key, 2)

    message.map(c => (c ^ keyi).toChar)
  }

}
