import java.util.*

fun getFibonacciHugeFast(n: Long, m: Long): Long {
    if (n <= 1) return n

    val listFib = arrayListOf(0L, 1L)
    val listMod = arrayListOf(0L, 1L)
    var found = false
    var i = 2
    while (!found) {
        listFib.add(listFib[i-1] + listFib[i-2])
        listMod.add((listMod[i-1] + listMod[i-2]) % m)
        if (listMod[i] == 1L && listMod[i-1] == 0L) {
            found = true
        } else {
            i++
        }
    }
    val sequence = i - 1
    return listMod[(n%sequence).toInt()]
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val m = scanner.nextLong()
    println(getFibonacciHugeFast(n, m))
}