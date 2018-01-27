fun main(args: Array<String>) {
    val (n, L, R) = readLine()!!.split(" ").map { it.toInt() }
    val a = readLine()!!.split(" ").map { it.toInt() }
    println(a.map {
        when {
            it < L -> L
            it > R -> R
            else -> it
        }
    }.joinToString(" "))
}