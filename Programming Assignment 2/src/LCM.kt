import java.util.*

fun lcmFast(a: Long, b: Long): Long {
    val min = if (a<b) a else b
    var lcm = min
    var found = false

    while (!found) {
        if (lcm % a == 0L && lcm % b == 0L) {
            found = true
        } else {
            lcm += min
        }
    }
    return lcm
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextLong()
    val b = scanner.nextLong()

    println(lcmFast(a, b))
}