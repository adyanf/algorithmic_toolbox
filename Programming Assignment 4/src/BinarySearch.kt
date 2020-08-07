import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun binarySearch(a: IntArray, x: Int): Int {
    var left = 0
    var right = a.size - 1

    while (left <= right) {
        val mid = (right + left) / 2

        when {
            x == a[mid] -> {
                return mid
            }
            a[mid] < x -> {
                left = mid + 1
            }
            a[mid] > x -> {
                right = mid - 1
            }
        }
    }

    return -1
}

fun linearSearch(a: IntArray, x: Int): Int {
    for (i in a.indices) {
        if (a[i] == x) return i
    }
    return -1
}

fun main(args: Array<String>) {
    val scanner = FastScanner1(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    val m = scanner.nextInt()
    val b = IntArray(m)
    for (i in 0 until m) {
        b[i] = scanner.nextInt()
    }
    for (i in 0 until m) {
        //replace with the call to binarySearch when implemented
        print(binarySearch(a, b[i]).toString() + " ")
    }
}

class FastScanner1(stream: InputStream) {
    var br: BufferedReader = BufferedReader(InputStreamReader(stream))
    var st: StringTokenizer? = null

    fun next(): String {
        while (st == null || !st!!.hasMoreTokens()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt() = next().toInt()
}