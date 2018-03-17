import java.util.*

private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

sealed class Point(val coord: Pair<Int, Int>) {
    class Red(coord: Pair<Int, Int>): Point(coord)
    class Blue(coord: Pair<Int, Int>): Point(coord)
}

fun takeInputs(n: Int) = (1..n).map {
    val (a, b) = readInts()
    a to b
}

fun main(args: Array<String>) {
    val N = readInts()[0]
    val reds = takeInputs(N).map { Point.Red(it) }
    val blues = takeInputs(N).map { Point.Blue(it) }

    val points = (reds + blues).sortedBy { it.coord.first }

    val redCache = HashSet<Point.Red>()
    points.forEach { point ->
        when (point) {
            is Point.Red -> redCache.add(point)
            is Point.Blue -> {
                redCache
                        .filter { it.coord.second < point.coord.second }
                        .maxBy { it.coord.second }
                        ?.let {
                            redCache.remove(it)
                        }
            }
        }
    }

    println(N - redCache.size)
}