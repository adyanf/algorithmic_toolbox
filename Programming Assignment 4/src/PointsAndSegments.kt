import java.util.*

data class PointSegment(val value: Int, val type: PointSegmentType)
enum class PointSegmentType {
    START, POINT, END
}

fun fastCountSegments(starts: IntArray, ends: IntArray, points: IntArray): IntArray {
    val listOfPointSegment = mutableListOf<PointSegment>()
    val listOfResult = hashMapOf<Int, Int>()
    starts.forEach {
        listOfPointSegment.add(PointSegment(it, PointSegmentType.START))
    }
    ends.forEach {
        listOfPointSegment.add(PointSegment(it, PointSegmentType.END))
    }
    points.forEach {
        listOfPointSegment.add(PointSegment(it, PointSegmentType.POINT))
    }
    listOfPointSegment.sortWith(compareBy(PointSegment::value, PointSegment::type))

    val stackCheck = Stack<Int>()
    listOfPointSegment.forEach {
        when (it.type) {
            PointSegmentType.START -> stackCheck.push(it.value)
            PointSegmentType.END -> stackCheck.pop()
            PointSegmentType.POINT -> listOfResult[it.value] = stackCheck.size
        }
    }

    return points.map { listOfResult[it] ?: 0 }.toIntArray()
}

fun naiveCountSegments(starts: IntArray, ends: IntArray, points: IntArray): IntArray {
    val cnt = IntArray(points.size)
    for (i in points.indices) {
        for (j in starts.indices) {
            if (starts[j] <= points[i] && points[i] <= ends[j]) {
                cnt[i]++
            }
        }
    }
    return cnt
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n: Int
    val m: Int
    n = scanner.nextInt()
    m = scanner.nextInt()
    val starts = IntArray(n)
    val ends = IntArray(n)
    val points = IntArray(m)
    for (i in 0 until n) {
        starts[i] = scanner.nextInt()
        ends[i] = scanner.nextInt()
    }
    for (i in 0 until m) {
        points[i] = scanner.nextInt()
    }
    //use fastCountSegments
    val cnt = fastCountSegments(starts, ends, points)
    for (x in cnt) {
        print(x.toString() + " ")
    }
}