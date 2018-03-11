private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

private fun Long.positiveOrZero() = if (this > 0) this else 0

fun main(args: Array<String>) {
    val (N, K) = readInts().map { it.toLong() }
    if (K == 0L) return println(N * N)

    val suchPairsNum = (2..N).map { a ->
        (a - K).positiveOrZero() * (N / a) + (N % a - K + 1).positiveOrZero()
    }

    println(suchPairsNum.sum())
}