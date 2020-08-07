import java.util.*

fun computeMinRefills(dist: Int, tank: Int, stops: IntArray?): Int {
    if (stops == null) {
        return if (dist <= tank) 0 else -1
    }
    val point = intArrayOf(0) + stops + intArrayOf(dist)

    var nFills = 0
    var current = 0
    var impossible = false
    while (current <= stops.size && !impossible) {
        val lastRefill = current
        while (current <= stops.size && point[current+1] - (point.getOrNull(lastRefill) ?: 0) <= tank) {
            current++
        }
        if (current == lastRefill) {
            impossible = true
            break
        }
        if (current <= stops.size) nFills++
    }
    return if (impossible) -1 else nFills
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val dist = scanner.nextInt()
    val tank = scanner.nextInt()
    val n = scanner.nextInt()
    val stops = IntArray(n)
    for (i in 0 until n) {
        stops[i] = scanner.nextInt()
    }
    println(computeMinRefills(dist, tank, stops))
}