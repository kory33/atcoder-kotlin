private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val (a, b) = readInts()
    val included = a <= b
    println(a - 1 + if(included) 1 else 0)
}