import java.util.*

fun getFibonacciSumLastDigitFast(n: Long): Long {
    val arrayListSum = arrayListOf(0L, 1L)
    val sumLastDigitIndex = n % 60
    var previous = 0L
    var current = 1L
    for (i in 2 until sumLastDigitIndex + 1) {
        val tempPrevious = previous
        previous = current
        current = (current + tempPrevious) % 10
        arrayListSum.add((arrayListSum[i.toInt() - 1] + current) % 10)
    }
    return arrayListSum[sumLastDigitIndex.toInt()]
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val s = getFibonacciSumLastDigitFast(n)
    println(s)
}