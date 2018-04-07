private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val nums = readInts()
    val diff = nums.map { it - nums.min()!! }.sorted()
    val (_dm, a, b) = diff
    println(a / 2 + a % 2 + (b - a / 2 * 2))
}