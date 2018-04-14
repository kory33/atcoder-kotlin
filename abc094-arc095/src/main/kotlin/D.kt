private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun abs(a: Double) = if (a > 0) a else -a

fun main(args: Array<String>) {
    val n = readInts()[0]
    val a = readInts().sorted()
    val N = a.last()
    val half = N.toDouble() / 2
    val closestToHalf = a.dropLast(1).minBy { abs(half - it) }!!
    print("$N $closestToHalf")
}