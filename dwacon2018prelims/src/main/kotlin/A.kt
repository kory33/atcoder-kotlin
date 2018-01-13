fun main(args: Array<String>) {
    val S = readLine()!!
    print(if (S[0] == S[2] && S[1] == S[3]) "Yes" else "No")
}