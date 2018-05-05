private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val nums = readInts().map { it.toLong() }
    val K = readInts()[0]
    val max = nums.max()!!
    println(nums.sum() - max + (max shl K))
}