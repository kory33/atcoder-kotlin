fun solve(S: String): Int {
    if (S.length % 2 == 1 || S[0] == '5') {
        return -1
    }

    val twos = S.filter { c -> c == '2'}.length
    if (S.length / 2 != twos) return -1

    var reduced = S
    var answer = 0
    while (reduced.isNotEmpty()) {
        var previousWasTwo = false

        reduced = reduced.filter {
            val passesNicoTest = if (previousWasTwo) it == '5' else it == '2'
            if (passesNicoTest) previousWasTwo = it == '2'
            !passesNicoTest
        }
        answer += 1
    }

    return answer

}

fun main(args: Array<String>) {
    val S = readLine()!!
    print(solve(S))
}