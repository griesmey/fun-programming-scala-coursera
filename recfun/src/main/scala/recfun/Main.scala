package recfun

import collection.mutable

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
    def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      val stack = mutable.Stack[Char]()

      def loop(chars: List[Char]): Unit =

        if (chars.nonEmpty) {
          if (chars.head == '(')
            stack.push(chars.head)

          else if (chars.head == ')')
            if (stack.nonEmpty && stack.top == '(')
              stack.pop()
            else
              stack.push(chars.head)
          loop(chars.tail)
        }
      loop(chars)
      if (stack.isEmpty) true
      else false
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money > 0 && coins.nonEmpty)
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
      else 0
    }
  }
