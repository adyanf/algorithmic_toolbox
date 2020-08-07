import java.util.*
import kotlin.math.min

fun optimalSequence(n: Int): List<Int> {
    val minStepCalculator = IntArray(size = n + 1) { 0 }
    for (i in 1..n) {
        val minStepAdd1 = minStepCalculator.getOrElse(i-1) { Int.MAX_VALUE - 1 } + 1
        val minStepMultiply2 = if (i % 2 == 0) {
            minStepCalculator.getOrElse(i/2) { Int.MAX_VALUE - 1 } + 1
        } else Int.MAX_VALUE
        val minStepMultiply3 = if (i % 3 == 0) {
            minStepCalculator.getOrElse(i/3) { Int.MAX_VALUE - 1 } + 1
        } else Int.MAX_VALUE
        minStepCalculator[i] = min(min(minStepAdd1, minStepMultiply2), minStepMultiply3)
    }
    val steps = mutableListOf(n)
    var current = n
    while (current > 1L) {
        val minStepDistract1 = minStepCalculator.getOrElse(current-1) { Int.MAX_VALUE }
        val minStepDivide2 = if (current % 2 == 0) {
            minStepCalculator.getOrElse(current/2) { Int.MAX_VALUE - 1 }
        } else Int.MAX_VALUE
        val minStepDivide3 = if (current % 3 == 0) {
            minStepCalculator.getOrElse(current/3) { Int.MAX_VALUE - 1 }
        } else Int.MAX_VALUE
        if (minStepDistract1 <= minStepDivide2 && minStepDistract1 <= minStepDivide3) {
            current -= 1
        } else if (minStepDivide2 <= minStepDistract1 && minStepDivide2 <= minStepDivide3) {
            current /= 2
        } else if (minStepDivide3 <= minStepDistract1 && minStepDivide3 <= minStepDivide2) {
            current /= 3
        }
        steps.add(current)
    }
    return steps.reversed()
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val sequence = optimalSequence(n)
    println(sequence.size - 1)
    for (x in sequence) {
        print(x.toString() + " ")
    }
}