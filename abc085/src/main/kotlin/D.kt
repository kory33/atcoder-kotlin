inline fun <T> T.also(block: (T) -> Unit): T { block(this); return this }

fun Int.divCeil(a: Int) = (this + a - 1) / a

fun main(args: Array<String>) {
    val (N, H) = readLine()!!.split(" ").map{ it.toInt() }
    val damages = (1..N).map { readLine()!!.split(" ").map{ it.toInt() }.let{ Pair(it[0], it[1])} }

    val normalDamageMax = damages
            .map { it.first }.max()!!
    val throwDamageSorted = damages
            .map { it.second }
            .filter { it > normalDamageMax }
            .sortedDescending()
    val throwDamageSum = throwDamageSorted.sum()

    print(if (throwDamageSum < H) {
        throwDamageSorted.size + (H - throwDamageSum).divCeil(normalDamageMax)
    } else {
        var partSum = 0
        throwDamageSorted.takeWhile { b ->
            (partSum < H).also {
                partSum += b
            }
        }.size
    })
}