import java.util.*

private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

const val BLOCK_WIDTH = 100
const val BLOCK_HEIGHT = 50

class Grid: ArrayList<MutableList<Boolean>>() {

    private var currentInvertTarget = Pair(1, 1)

    init {
        for (i in (0 until BLOCK_HEIGHT)) {
            this.add((0 until BLOCK_WIDTH).map { false }.toMutableList())
        }
    }

    fun invert() {
        val (targetX, targetY) = currentInvertTarget
        this[targetY][targetX] = true

        val (newX, newY) = when {
            targetX >= BLOCK_WIDTH - 3 -> 1 to targetY + 2
            else -> targetX + 2 to targetY
        }

        currentInvertTarget = newX to newY
    }

    fun invert(times: Int): Grid {
        for (i in (0 until times)) invert()
        return this
    }

    fun toString(base: Char, inverted: Char) = this.joinToString("\n") {
        String(it.map { if (it) inverted else base }.toCharArray())
    }

}

fun main(args: Array<String>) {
    val (A, B) = readInts()

    println("${BLOCK_HEIGHT * 2} $BLOCK_WIDTH")
    println(Grid().invert(B - 1).toString('.', '#'))
    println(Grid().invert(A - 1).toString('#', '.'))
}