object NumberCategorizer extends App {
  // Check if a number is a multiple of 3
  val isMultipleOfThree: Int => Boolean = (n: Int) => n % 3 == 0

  // Check if a number is a multiple of 5
  val isMultipleOfFive: Int => Boolean = (n: Int) => n % 5 == 0

  // Pattern match the input and categorize it
  def categorizeNumber(n: Int): String = (isMultipleOfThree(n), isMultipleOfFive(n)) match {
    case (true, true) => "Multiple of Both Three and Five"
    case (true, false) => "Multiple of Three"
    case (false, true) => "Multiple of Five"
    case _ => "Not a Multiple of Three or Five"
  }

  // Parse the command line input
  if (args.length > 0) {
    val input = args(0).toInt
    println(categorizeNumber(input))
  } else {
    println("Please provide an integer input.")
  }
}
