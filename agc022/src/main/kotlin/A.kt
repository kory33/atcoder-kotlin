private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

private inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }
private fun <T> List<T>.pairAdjacent() = when {
    isNotEmpty() -> {
        var prev = first()
        map { elem -> (prev to elem).also { prev = elem } }
    }
    else -> listOf()
}

val lastString = ('a'..'z').reversed().joinToString("")

private fun String.extendWith(selectionIndex: Int): String {
    val chars = this.toSet()
    val smallest = ('a'..'z').filter { !chars.contains(it) }[selectionIndex]
    return this + smallest
}

fun main(args: Array<String>) {
    val S = readLine()!!
    val answer = when {
        S.length != 26 -> S.extendWith(0)
        S != lastString -> {
            val swapIndex = S.toList().pairAdjacent().indexOfLast { p ->
                val (pr, nx) = p
                pr < nx
            }
            S.substring(0, swapIndex - 1).extendWith(1)
        }
        else -> "-1"
    }
    println(answer)
}