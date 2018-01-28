private fun readLineStrings(): List<String> = readLine()!!.split(" ")
private fun readLineInts(): List<Int> = readLineStrings().map { it.toInt() }

private fun List<Int>.firstLineCumulativeCandy(): List<Int> {
    var tempSum = 0
    return this.map {
        tempSum += it
        tempSum
    }
}

private fun List<Int>.nextLineCumulativeCandy(nextLine: List<Int>): List<Int> {
    var leftWiseMax = this.first()
    return nextLine.mapIndexed { idx, p ->
        leftWiseMax = listOf(leftWiseMax, this[idx]).max()!! + p
        leftWiseMax
    }
}


fun main(args: Array<String>) {
    val N = readLineInts()[0]
    val A = readLineInts()
    val B = readLineInts()

    println(A.firstLineCumulativeCandy().nextLineCumulativeCandy(B).last())
}