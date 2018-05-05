private fun readStrings() = readLine()!!.split(" ")
private fun readInts() = readStrings().map { it.toInt() }

fun canPaint(grid: List<String>, h: Int, w: Int): Boolean {
    for (height in 0 until h) {
        for (column in 0 until w) {
            val char = grid[height][column]
            if (char == '#') {
                val up   = grid.getOrNull(height - 1)?.getOrNull(column) == '#'
                val down = grid.getOrNull(height + 1)?.getOrNull(column) == '#'
                val left = grid.getOrNull(height)?.getOrNull(column - 1) == '#'
                val right= grid.getOrNull(height)?.getOrNull(column + 1) == '#'
                if (!(up || down || left || right)) {
                    return false
                }
            }
        }
    }
    return true
}

fun main(args: Array<String>) {
    val (H, W) = readInts()
    val s = (1 .. H).map { readLine()!! }

    println(if (canPaint(s, H, W)) "Yes" else "No")
}