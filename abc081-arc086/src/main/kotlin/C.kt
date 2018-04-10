private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val (N, K) = readInts()
    val A = readInts()
    val counts = A.groupBy { it }.mapValues { p -> p.value.size }.values.sorted()
    val toChange = counts.size - K
    println(if (toChange > 0) counts.take(toChange).sum() else 0)
}