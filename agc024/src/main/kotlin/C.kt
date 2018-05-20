private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val N = readInts()[0]
    val a = (1 .. N).map { readInts()[0] }

    if (a[0] != 0) println(-1)
    else {
        var counts = 0L
        var prev = a[0]
        for (num in a.drop(1)) {
            if (num > prev) {
                if (num - prev > 1) {
                    println(-1)
                    return
                } else {
                    counts++
                }
            } else {
                counts += num
            }
            prev = num
        }
        println(counts)
    }
}