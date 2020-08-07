import java.util.*

fun largestNumber(a: MutableList<String>): String {
    var answer = ""
    while (a.isNotEmpty()) {
        var maxDigit = 0
        for (c in a) {
            if (isGreaterOrEqual(c, maxDigit.toString())) {
                maxDigit = c.toInt()
            }
        }
        answer += maxDigit
        a.remove(maxDigit.toString())
    }

    return answer
}

fun isGreaterOrEqual(a: String, b: String): Boolean {
    return "$a$b".toInt() >= "$b$a".toInt()
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = ArrayList<String>(n)
    repeat(n) {
        a += scanner.next()
    }
    println(largestNumber(a))
}