import java.util.*

private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

private inline fun <T, R> Collection<T>.scanIndexed(initial: R, operation: (Int, R, T) -> R): List<R> {
    val result = ArrayList<R>(size)
    var prevResult = initial
    forEachIndexed { index, element ->
        val elementResult = operation(index, prevResult, element)
        result.add(elementResult)
        prevResult = elementResult
    }
    return result
}

private inline fun <T> Iterable<T>.scanIndexed1(operation: (Int, T, T) -> T): List<T>
        = drop(1).scanIndexed(first(), operation)

private inline fun <T> Iterable<T>.scan1(operation: (T, T) -> T): List<T>
        = scanIndexed1 {i, list, elem -> operation(list, elem)}

fun main(args: Array<String>) {
    val N = readInts()[0]
    val a = readInts().map{ it.toLong() }
    println(
            (listOf(0L, 0L) + a)
            .scan1 { a, b -> a + b }
            .groupBy { it }.map { it.value.size.toLong() }
            .map { it * (it - 1L) / 2L }
            .sum()
    )
}