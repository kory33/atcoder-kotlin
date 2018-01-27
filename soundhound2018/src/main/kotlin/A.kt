fun main(args: Array<String>) {
    if (readLine()!!.split(" ").map { it[0] }.joinToString("") == "SH" ) {
        println("YES")
    } else println("NO")
}