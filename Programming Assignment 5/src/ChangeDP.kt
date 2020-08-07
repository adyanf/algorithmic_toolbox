import java.util.*
import kotlin.math.min

fun getChange(m: Int): Int {
    val minCoinChange = IntArray(size = m + 1) { 0 }
    for (i in 1..m) {
        val coinChange1 = minCoinChange.getOrElse(i-1) { Int.MAX_VALUE - 1 } + 1
        val coinChange3 = minCoinChange.getOrElse(i-3) { Int.MAX_VALUE - 1 } + 1
        val coinChange4 = minCoinChange.getOrElse(i-4) { Int.MAX_VALUE - 1 } + 1
        minCoinChange[i] = min(min(coinChange1, coinChange3),coinChange4)
    }
    return minCoinChange[m]
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val m = scanner.nextInt()
    println(getChange(m))
}