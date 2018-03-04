fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val S = (0 until N).map { readLine()!! }
    val nums = S.map { it.first() }.groupBy { it }.mapValues { it.value.size.toLong() }
    val march = "MARCH".map { nums[it] ?: 0 }

    val sum = (0 until 5).map { first -> (first + 1 until 5).map { second ->
        (0 until 5).filter { it != first && it != second }.map{ march[it] }.reduce { a, b -> a * b }
    }.fold(0L) { a, b -> a + b} }.fold(0L) {a, b -> a + b}
    println(sum)
}