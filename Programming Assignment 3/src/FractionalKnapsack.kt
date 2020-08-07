import java.util.*
import kotlin.math.min

fun getOptimalValue(capacity: Int, values: IntArray, weights: IntArray): Double {
    val things = weights.mapIndexed { index, weight ->
        weight to values[index]
    }.sortedByDescending { it.second.toDouble() / it.first.toDouble() }
    var remainingCapacity = capacity
    var index = 0
    var value = 0.0
    while (remainingCapacity > 0 && index < things.size) {
        val toBag = min(remainingCapacity, things[index].first)
        value += things[index].second * (toBag.toDouble() / things[index].first.toDouble())
        remainingCapacity -= toBag
        index++
    }
    return value
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val capacity = scanner.nextInt()
    val values = IntArray(n)
    val weights = IntArray(n)
    for (i in 0 until n) {
        values[i] = scanner.nextInt()
        weights[i] = scanner.nextInt()
    }
    val optimalValue = getOptimalValue(capacity, values, weights)
    println(String.format("%.4f", optimalValue))
}