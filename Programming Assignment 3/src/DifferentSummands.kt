import java.util.*

fun optimalSummands(n: Int): List<Int> {
    var remainingCandy = n
    var maxCandy = 0
    val candies = arrayListOf<Int>()
    while (remainingCandy > 0) {
        val newCandy = maxCandy + 1
        if (remainingCandy - newCandy > newCandy) {
            candies.add(newCandy)
            maxCandy = newCandy
            remainingCandy -= newCandy
        } else {
            candies.add(remainingCandy)
            maxCandy = remainingCandy
            remainingCandy -= remainingCandy
        }
    }
    return candies
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val summands = optimalSummands(n)
    println(summands.size)
    for (summand in summands) {
        print(summand.toString() + " ")
    }
}