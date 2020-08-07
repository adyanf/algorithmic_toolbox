import java.util.*

fun gcdFast(a: Int, b: Int): Int {
    if (b == 0) return a

    return gcdFast(b, a % b)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()

    println(gcdFast(a, b))
}