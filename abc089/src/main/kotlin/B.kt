fun main(args: Array<String>) {
    readLine()
    if (readLine()!!.split(" ").any { it == "Y" }) {
        println("Four")
    } else println("Three")
}