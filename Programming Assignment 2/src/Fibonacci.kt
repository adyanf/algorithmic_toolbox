import java.util.*

fun calcFib(n: Int): Long {
    val fibNum = arrayListOf<Long>(0, 1)
    for (i in 2 until n+1) {
        fibNum.add(fibNum[i-1] + fibNum[i-2])
    }
    return fibNum[n]
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    println(calcFib(n))
}