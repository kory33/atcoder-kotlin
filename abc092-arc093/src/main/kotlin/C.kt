private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

private fun getCost(a: Int, b: Int) = Math.abs(a - b)
private fun Pair<Int, Int>.getCost() = getCost(first, second)

private fun computeMiddleOmitDiff(a: Int, b: Int, c: Int) = getCost(a, c) - (getCost(a, b) + getCost(b, c))

private inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }

private fun <T> List<T>.pairAdjacent() = when {
    isNotEmpty() -> {
        var prev = first()
        map { elem -> (prev to elem).also { prev = elem } }
    }
    else -> listOf()
}

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val A = readInts()

    val paths = listOf(0) + A + listOf(0)
    val totalCost = paths.pairAdjacent().map { it.getCost() }.sum()

    (1 until N+1).forEach { index ->
        val (a, b, c) = listOf(index - 1, index, index + 1).map { paths[it] }
        println(totalCost + computeMiddleOmitDiff(a, b, c))
    }
}