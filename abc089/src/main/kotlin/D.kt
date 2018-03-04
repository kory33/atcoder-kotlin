operator fun Pair<Int, Int>.plus(pair: Pair<Int, Int>) = Pair(first + pair.first, second + pair.second)
operator fun Pair<Int, Int>.minus(pair: Pair<Int, Int>) = Pair(first - pair.first, second - pair.second)
fun Pair<Int, Int>.manhattanTo(pair: Pair<Int, Int>) = (this - pair).manhattanLength()
fun Pair<Int, Int>.manhattanLength() = Math.abs(first) + Math.abs(second)

fun main(args: Array<String>) {
    val (H, W, D) = readLine()!!.split(" ").map { it.toInt() }
    val A = (0 until H).map { readLine()!!.split(" ").map { it.toInt() } }
    val numberCache: Map<Int, Pair<Int, Int>> = {
        val result = mutableMapOf<Int, Pair<Int, Int>>()
        (0 until H).forEach { h ->
            (0 until W).forEach { w ->
                result[A[h][w]] = Pair(h, w)
            }
        }
        result
    }()
    val mpCache: Map<Int, Int> = {
        val result = mutableMapOf<Int, Int>()
        (1 until D + 1).forEach { width ->
            var index = width
            while (index <= H * W) {
                val prevIndex = index - D
                val totalMp = result[prevIndex]?.let { previous ->
                    val diff = numberCache[prevIndex]!!.manhattanTo(numberCache[index]!!)
                    previous + diff
                } ?: 0

                result[index] = totalMp
                index += width
            }
        }
        result
    }()

    val Q = readLine()!!.toInt()
    (0 until Q).forEach {
        val (L, R) = readLine()!!.split(" ").map { it.toInt() }
        println(mpCache[R]!! - mpCache[L]!!)
    }
}