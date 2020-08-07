import java.util.*

fun getFibonacciPartialSumLastDigitFast(from: Long, to: Long): Long {
    val arrayListSum = arrayListOf(0L, 1L)
    var previous = 0L
    var current = 1L
    for (i in 2 until 61) {
        val tempPrevious = previous
        previous = current
        current = (current + tempPrevious) % 10
        arrayListSum.add((arrayListSum[i - 1] + current) % 10)
    }
    val start = from % 60
    val finish = to % 60
    return when {
        start == 0L -> {
            arrayListSum[finish.toInt()]
        }
        arrayListSum[finish.toInt()] < arrayListSum[start.toInt() -1] -> {
            10 + arrayListSum[finish.toInt()] - arrayListSum[start.toInt() - 1]
        }
        else -> {
            arrayListSum[finish.toInt()] - arrayListSum[start.toInt() - 1]
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val from = scanner.nextLong()
    val to = scanner.nextLong()
    println(getFibonacciPartialSumLastDigitFast(from, to))
}