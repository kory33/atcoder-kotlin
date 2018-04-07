private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

private inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }

fun search(lowerBound: Long, upperBound: Long, ab: Long): Long {
    if (upperBound == lowerBound) return lowerBound
    if (upperBound == lowerBound + 1) {
        return if (upperBound * upperBound < ab) upperBound else lowerBound
    }
    val pivot = (lowerBound + upperBound) / 2

    return if (pivot * pivot < ab) search(pivot, upperBound, ab)
    else search(lowerBound, pivot - 1, ab)
}

fun query(a: Long, b: Long): Long {
    val ab = a * b
    val f = (a - 1) * 2
    return f + if ((a + 1) * (a + 1) < ab) {
        val m = search(a + 1, b - 1, ab)
        val alpha = m - a
        if (m * (m + 1) < ab) {
            2 * alpha + (if (a + alpha * 2 + 1 < b) 1 else 0)
        } else {
            (alpha - 1) * 2 + 1 + + (if (a + alpha * 2 < b) 1 else 0)
        }
    } else {
        if (a + 1 < b) 1L else 0L
    }
}

fun main(args: Array<String>) {
    val Q = readInts()[0]
    (0 until Q).forEach {
        val (a, b) = readInts().sorted()
        println(query(a.toLong(), b.toLong()))
    }
}