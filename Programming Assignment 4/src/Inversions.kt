import java.util.*

fun mergeSort(a: IntArray, left: Int, right: Int): Long {
    if (left < right) {
        val mid = (left + right) / 2

        val resultA = mergeSort(a, left, mid)
        val resultB = mergeSort(a, mid+1, right)

        val result = merge(a, left, mid, right)

        return result + resultA + resultB
    }
    return 0
}

fun merge(a: IntArray, left: Int, mid: Int, right: Int): Long {
    val result = mutableListOf<Int>()
    var pair = 0L
    var i = left
    var j = mid + 1
    while (i < mid + 1 && j < right + 1) {
        if (a[i] <= a[j]) {
            result.add(a[i])
            i++
            pair += (j - (mid + 1))
        } else {
            result.add(a[j])
            j++
        }
    }
    if (i < mid + 1) {
        while (i < mid + 1) {
            result.add(a[i])
            i++
            pair += (j - (mid + 1))
        }
    }
    if (j < right + 1) {
        while (j < right + 1) {
            result.add(a[j])
            j++
        }
    }
    var k = 0
    for (l in left..right) {
        a[l] = result[k]
        k++
    }
    return pair
}
fun getNumberOfInversions(a: IntArray, b: IntArray, left: Int, right: Int): Long {
    var numberOfInversions: Long = 0
    if (right <= left + 1) {
        return numberOfInversions
    }
    val ave = (left + right) / 2
    numberOfInversions += getNumberOfInversions(a, b, left, ave)
    numberOfInversions += getNumberOfInversions(a, b, ave, right)
    //write your code here
    return numberOfInversions
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    val mid = (0 + a.size - 1) / 2
    println(mergeSort(a,0, a.size - 1))
}