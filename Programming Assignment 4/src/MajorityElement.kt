import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun getMajorityElement(a: IntArray): Int {
    val map = hashMapOf<Int, Int>()
    a.forEach {
        map[it] = (map[it] ?: 0) + 1
    }

    var maxCount = 0
    var maxElement = -1
    for (count in map) {
        if (count.value > maxCount) {
            maxCount = count.value
            maxElement = count.key
        }
    }

    return if (a.filter { it == maxElement }.size > (a.size / 2)) {
        maxElement
    } else -1
}

fun main(args: Array<String>) {
    val scanner = FastScanner2(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    if (getMajorityElement(a) != -1) {
        println(1)
    } else {
        println(0)
    }
}

class FastScanner2(stream: InputStream) {
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