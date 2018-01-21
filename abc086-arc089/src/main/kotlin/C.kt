operator fun Pair<Int, Int>.minus(pair: Pair<Int, Int>) = Pair(first - pair.first, second - pair.second)
fun Pair<Int, Int>.manhattanTo(pair: Pair<Int, Int>) = (this - pair).manhattanLength()
fun Pair<Int, Int>.manhattanLength() = Math.abs(first) + Math.abs(second)

data class WayPoint(private val t: Int, private val coordinate: Pair<Int, Int>) {
    private fun timeTo(wayPoint: WayPoint) = wayPoint.t - t

    fun canThenReachTo(wayPoint: WayPoint) = coordinate.manhattanTo(wayPoint.coordinate).let { distance ->
        distance <= timeTo(wayPoint) && timeTo(wayPoint) % 2 == distance % 2
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val initialPoint = WayPoint(0, Pair(0, 0))
    val wayPoints = listOf(initialPoint) + (0 until n).map {
        val (t, x, y) = readLine()!!.split(" ").map { it.toInt() }
        WayPoint(t, Pair(x, y))
    }

    val travellable = wayPoints.mapIndexedNotNull { index, wayPoint ->
        wayPoints.getOrNull(index + 1)?.let { nextWayPoint ->
            Pair(wayPoint, nextWayPoint)
        }
    }.all { it.first.canThenReachTo(it.second) }

    println(if (travellable) "Yes" else "No")
}