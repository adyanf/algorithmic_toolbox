import java.util.*
import kotlin.math.max
import kotlin.math.min

fun optimalPoints(segments: MutableList<Segment>): IntArray {
    val sortedSegment = segments.sortedBy { it.start }
    val result = arrayListOf<Int>()
    var tempSegment = sortedSegment.first()
    var index = 1

    while (index < sortedSegment.size) {
        if (isMeet(tempSegment, sortedSegment[index])) {
            tempSegment = Segment(
                start = max(tempSegment.start, sortedSegment[index].start),
                end = min(tempSegment.end, sortedSegment[index].end)
            )
        } else {
            result.add(tempSegment.end)
            tempSegment = sortedSegment[index]
        }
        index++
        if (index == sortedSegment.size) {
            result.add(tempSegment.end)
        }
    }

    return result.toIntArray()
}

fun isMeet(segmentA: Segment, segmentB: Segment): Boolean {
    return max(segmentA.start,segmentB.start) <=
        min(segmentA.end, segmentB.end)
}

class Segment(var start: Int, var end: Int)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val segments = ArrayList<Segment>(n)
    repeat (n) {
        val start: Int = scanner.nextInt()
        val end: Int = scanner.nextInt()
        segments += Segment(start, end)
    }
    val points = optimalPoints(segments)
    println(points.size)
    for (point in points) {
        print(point.toString() + " ")
    }
}