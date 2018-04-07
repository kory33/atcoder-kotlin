private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun query(a: Long, b: Long): Long {
    val ab = a * b
    return (a - 1) * 2 +
            when {
                (a + 1) * (a + 1) < ab -> {
                    val pairCentre = Math.ceil(Math.sqrt(ab.toDouble()) - 1).toLong()
                    val alpha = pairCentre - a
                    if (pairCentre * (pairCentre + 1) < ab) 2 * alpha else (alpha - 1) * 2 + 1
                }
                else -> 0L
            } +
            when {
                a + 1 < b -> 1L
                else -> 0L
            }
}

fun main(args: Array<String>) {
    val Q = readInts()[0]
    (0 until Q).forEach {
        val (a, b) = readInts().sorted()
        println(query(a.toLong(), b.toLong()))
    }
}