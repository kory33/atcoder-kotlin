operator fun Pair<Int, Int>.plus(pair: Pair<Int, Int>) = Pair(first + pair.first, second + pair.second)
operator fun Pair<Int, Int>.minus(pair: Pair<Int, Int>) = Pair(first - pair.first, second - pair.second)
fun Pair<Int, Int>.manhattanTo(pair: Pair<Int, Int>) = (this - pair).manhattanLength()
fun Pair<Int, Int>.manhattanLength() = Math.abs(first) + Math.abs(second)

private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

private fun List<IntRange>.zipWithIndices() =
        mapIndexed { first, range ->
            range.map { second -> Pair(first, second) }
        }.flatten()

fun main(args: Array<String>) {
    val (H, W, D) = readInts()
    val A = (0 until H).map { readInts() }

    val numberCache = {
        val result = mutableMapOf<Int, Pair<Int, Int>>()
        (0 until H).map { (0 until W) }.zipWithIndices().forEach { pair ->
            val (h, w) = pair
            result[A[h][w]] = Pair(h, w)
        }
        result
    }()

    val mpCache = {
        val result = mutableMapOf<Int, Int>()
        (1 until H * W + 1).forEach { index ->
            val prevIndex = index - D

            result[index] = result[prevIndex]?.let { previous ->
                val diff = numberCache[prevIndex]!!.manhattanTo(numberCache[index]!!)
                previous + diff
            } ?: 0
        }
        result
    }()

    val Q = readLine()!!.toInt()
    (0 until Q).forEach {
        val (L, R) = readInts()
        println(mpCache[R]!! - mpCache[L]!!)
    }
}