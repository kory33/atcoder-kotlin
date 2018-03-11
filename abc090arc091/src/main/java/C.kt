private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun main(args: Array<String>) {
    val (N, M) = readInts().map { it.toLong() }

    print(when {
        M > 1  && N > 1  -> (M - 2) * (N - 2)
        M == 1L && N > 1  -> N - 2
        M > 1  && N == 1L -> M - 2
        M == 1L && N == 1L -> 1
        else -> throw Error()
    })
}