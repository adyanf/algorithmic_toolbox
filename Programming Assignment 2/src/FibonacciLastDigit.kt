import java.util.*

fun getFibonacciLastDigitFast(n: Int): Int {
    if (n <= 1) return n

    var previous = 0
    var current = 1

    for (i in 2 until n+1) {
        val tmpPrevious = previous
        previous = current
        current = (current + tmpPrevious) % 10
    }

    return current
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val c = getFibonacciLastDigitFast(n)
    println(c)
}