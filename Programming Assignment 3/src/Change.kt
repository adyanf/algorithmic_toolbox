import java.util.*

fun getChange(m: Int): Int {
    var change = m
    var nChange = 0
    while (change > 0) {
        when {
            change >= 10 -> {
                change -= 10
                nChange++
            }
            change >= 5 -> {
                change -= 5
                nChange++
            }
            change >= 1 -> {
                change -= 1
                nChange++
            }
        }
    }
    return nChange
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val m = scanner.nextInt()
    println(getChange(m))
}