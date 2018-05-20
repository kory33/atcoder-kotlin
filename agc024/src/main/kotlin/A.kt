private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val (A, B, C, K) = readStrings().map { it.toLong() }
    println((A - B) * (if (K % 2L == 0L) 1 else -1))
}