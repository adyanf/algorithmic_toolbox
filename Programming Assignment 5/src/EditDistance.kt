import java.util.*
import kotlin.math.min

fun getEditDistance(s: String, t: String): Int {
    val matrixED = Array(s.length + 1) {
        IntArray(t.length + 1)
    }
    for (i in 0..s.length) {
        for (j in 0..t.length) {
            if (i == 0) {
                matrixED[i][j] = j
            } else if (j == 0) {
                matrixED[i][j] = i
            } else {
                if (s[i-1] == t[j-1]) {
                    matrixED[i][j] = matrixED[i-1][j-1]
                } else {
                    matrixED[i][j] = 1 + min(
                        min(matrixED[i][j-1], matrixED[i-1][j]),
                        matrixED[i-1][j-1]
                    )
                }
            }
        }
    }
    return matrixED[s.length][t.length]
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.next()
    val t = scan.next()

    println(getEditDistance(s, t))
}