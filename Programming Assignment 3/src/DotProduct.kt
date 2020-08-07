import java.util.*

fun maxDotProduct(a: IntArray, b: IntArray): Long {
    val sortedA = a.sorted()
    val sortedB = b.sorted()
    var result = 0L
    for (i in a.indices) {
        result += sortedA[i].toLong() * sortedB[i].toLong()
    }
    return result
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    val b = IntArray(n)
    for (i in 0 until n) {
        b[i] = scanner.nextInt()
    }
    println(maxDotProduct(a, b))
}