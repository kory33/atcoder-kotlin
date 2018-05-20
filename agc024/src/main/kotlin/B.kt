import java.util.*

private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val N = readInts()[0]
    val p = (1 .. N).map { readInts()[0] }

    val series = HashMap<Int, Int>()
    p.forEach {
        if (series.containsKey(it - 1)) {
            series[it] = series.remove(it - 1)!! + 1
        } else {
            series[it] = 1
        }
    }
    println(N - series.values.max()!!)
}