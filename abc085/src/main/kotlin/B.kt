fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val d = (1..N).map { readLine()!!.toInt() }.toSet()
    print(d.size)
}