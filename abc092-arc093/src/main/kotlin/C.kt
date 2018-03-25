private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun getCost(a: Int, b: Int) = Math.abs(a - b)
fun computeMiddleOmitDiff(a: Int, b: Int, c: Int) = getCost(a, c) - (getCost(a, b) + getCost(b, c))

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readInts()

    val paths = listOf(0) + A + listOf(0)
    val totalCost = paths.fold(Pair(0, 0)) { cp, next ->
        val (cost, prev) = cp
        cost + getCost(prev, next) to next
    }.first

    (1 until N+1).forEach { index ->
        val (a, b, c) = listOf(index - 1, index, index + 1).map { paths[it] }
        println(totalCost + computeMiddleOmitDiff(a, b, c))
    }
}