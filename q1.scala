object CaesarCipher {
  
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val shiftBase = if (char.isUpper) 'A' else 'a'
        ((char - shiftBase + shift) % 26 + shiftBase).toChar
      } else {
        char
      }
    }
  }

  def decrypt(text: String, shift: Int): String = {
    encrypt(text, 26 - shift)
  }

  def cipher(text: String, shift: Int, func: (String, Int) => String): String = {
    func(text, shift)
  }
  
  def main(args: Array[String]): Unit = {
    val text = "Hello World"
    val shift = 3

    val encrypted = cipher(text, shift, encrypt)
    println(s"Encrypted: $encrypted")

    val decrypted = cipher(encrypted, shift, decrypt)
    println(s"Decrypted: $decrypted")
  }
}
