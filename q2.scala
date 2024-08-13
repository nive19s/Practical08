import scala.io.StdIn.readInt

object NumberCategorizer {
  val isMultipleOfThree: Int => Boolean = (n: Int) => n % 3 == 0
  val isMultipleOfFive: Int => Boolean = (n: Int) => n % 5 == 0

  def categorizeNumber(n: Int): String = (isMultipleOfThree(n), isMultipleOfFive(n)) match {
    case (true, true) => "Multiple of Both Three and Five"
    case (true, false) => "Multiple of Three"
    case (false, true) => "Multiple of Five"
    case _ => "Multiple of Three or Five"
  }

  def main(args: Array[String]): Unit = {
    println("Please enter an integer:")
    val input = readInt()  
    println(categorizeNumber(input)) 
  }
}
