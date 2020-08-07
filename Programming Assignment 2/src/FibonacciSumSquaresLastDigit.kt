import java.util.*

fun getFibonacciSumSquaresFast(n: Long): Long {
    var previous = 0L
    var current = 1L

    for (i in 2 until (n%60)+2) {
        val tempPrevious = previous
        previous = current
        current = (current + tempPrevious) % 10
    }
    return (current * previous) % 10
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    println(getFibonacciSumSquaresFast(n))
}