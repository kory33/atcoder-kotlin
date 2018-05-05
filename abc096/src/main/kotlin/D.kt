private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun eratosthenes(bound: Int): Array<Boolean> {
    val primeList = Array(bound + 2) { true }
    val sieveBound = Math.ceil(Math.sqrt(bound.toDouble())).toInt()
    primeList[0] = false
    primeList[1] = false
    for (i in 2 .. sieveBound) {
        if (!primeList[i]) continue
        for (j in (2 * i .. bound).step(i)) {
            primeList[j] = false
        }
    }
    return primeList
}

fun Array<Boolean>.toPrimes() = mapIndexedNotNull { index, isPrime -> if (isPrime) index else null }

fun main(args: Array<String>) {
    val N = readInts()[0]
    val answer = eratosthenes(55555).toPrimes().filter { it % 5 == 1 }.take(N)
    println(answer.joinToString(" "))
}