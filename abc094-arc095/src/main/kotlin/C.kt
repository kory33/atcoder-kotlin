private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val N = readInts()[0]
    val X = readInts()
    val sortedX = X.sorted()
    val smallerMed = sortedX[N / 2 - 1]
    val largerMed = sortedX[N / 2]
    X.forEach {
        println(if (it < largerMed) largerMed else smallerMed)
    }
}