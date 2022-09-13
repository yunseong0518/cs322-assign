package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (c == r) 1
    else {
      pascal(c - 1, r -1) + pascal(c, r - 1)
    }
  } 

  /**
   * Exercise 2
   */
  def innerBalance(n: Int, chars: List[Char]): Int = {
    if (chars.isEmpty) 0
    else if (n < 0) -1
    else if (chars.head == '(') innerBalance(n + 1, chars.tail) + 1
    else if (chars.head == ')') innerBalance(n - 1, chars.tail) - 1
    else innerBalance(n, chars.tail)
  }

  def balance(chars: List[Char]): Boolean = {
    if (innerBalance(0, chars) == 0)  true
    else false
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0
    else if (money == 0) 1
    else if (money >= coins.head) {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    } else {
      countChange(money, coins.tail)
    }
  }
}
