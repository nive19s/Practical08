import scala.io.StdIn.readInt

object NumberCategorizer {
  // Lambda function to check if a number is a multiple of 3
  val isMultipleOfThree: Int => Boolean = (n: Int) => n % 3 == 0

  // Lambda function to check if a number is a multiple of 5
  val isMultipleOfFive: Int => Boolean = (n: Int) => n % 5 == 0

  // Function to categorize the number using pattern matching
  def categorizeNumber(n: Int): String = (isMultipleOfThree(n), isMultipleOfFive(n)) match {
    case (true, true) => "Multiple of Both Three and Five"
    case (true, false) => "Multiple of Three"
    case (false, true) => "Multiple of Five"
    case _ => "Not a Multiple of Three or Five"
  }

  def main(args: Array[String]): Unit = {
    println("Please enter an integer:")
    val input = readInt()  // Get user input
    println(categorizeNumber(input))  // Categorize and print the result
  }
}
