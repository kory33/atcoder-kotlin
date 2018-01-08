fun Triple<Int, Int, Int>.sum() = first * 10000 + second * 5000 + third * 1000

fun solve(N: Int, Y: Int): Triple<Int, Int, Int> {
    (0..N).forEach { x ->
        (0..N - x).forEach { y ->
            val z = N - x - y
            Triple(x, y, z).let {
                if (it.sum() == Y) return it
            }
        }
    }
    return Triple(-1, -1, -1)
}

fun main(args: Array<String>) {
    val (N, Y) = readLine()!!.split(" ").map{ it.toInt() }
    print(solve(N, Y).toList().joinToString(" "))
}