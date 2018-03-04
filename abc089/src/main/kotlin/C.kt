private fun List<IntRange>.zipWithIndices() =
        mapIndexed { first, range ->
            range.map { second -> Pair(first, second) }
        }.flatten()

private fun Iterable<Long>.product() = reduce { a, b -> a * b }

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val S = (0 until N).map { readLine()!! }
    val nums = S.map { it.first() }.groupBy { it }.mapValues { it.value.size.toLong() }
    val march = "MARCH".map { nums[it] ?: 0 }

    val sum = (0 until 5).map { (it + 1 until 5) }.zipWithIndices().map { pair ->
        val (first, second) = pair
        (0 until 5).filter { it != first && it != second }.map { march[it] }.product()
    }.sum()
    println(sum)
}