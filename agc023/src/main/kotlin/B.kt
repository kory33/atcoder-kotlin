private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

private fun List<String>.isSymmetric(): Boolean {
    for (i in (1 until size)) {
        for (j in (0 until i)) {
            if (this[i][j] != this[j][i]) {
                return false
            }
        }
    }
    return true
}

fun main(args: Array<String>) {
    val N = readInts()[0]
    val S = (1..N).map { readLine()!! }

    val SS = S + S

    println((0 until N).count { (SS.drop(it).take(N)).isSymmetric() } * N)
}