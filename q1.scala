import scala.io.StdIn.{readLine,readInt}

object CaesarCipher {

  def encrypt(normaltext: String, shift: Int): String = {
    normaltext.map { char =>
      if (char.isLetter) {
        val offset = if (char.isUpper) 'A' else 'a'
         val newChar = (char + shift - offset) % 26
        if (newChar < 0) (newChar + 26 + offset).toChar
        else (newChar + offset).toChar
      } else {
        char
      }
    }
  }

  def decrypt(ciphertext: String, shift: Int): String = {
    encrypt(ciphertext, -shift)
  }

  def cipher(text: String, shift: Int, processFunction: (String, Int) => String): String = {
    processFunction(text, shift)
  }

  def main(args: Array[String]): Unit = {
    println("Select an option: 1) Encrypt 2) Decrypt")
    val choice = readInt()

    println("Enter the text:")
    val text = readLine()

    println("Enter the shift value(Key value) : ")
    val shift = readInt()

    choice match {
      case 1 =>
        val encrypted = cipher(text, shift, encrypt)
        println(s"Encrypted Text: $encrypted")
      case 2 =>
        val decrypted = cipher(text, shift, decrypt)
        println(s"Decrypted Text: $decrypted")
      case _ =>
        println("Please select a valid option.")
    }
  }
}