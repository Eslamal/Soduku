fun main(args: Array<String>) {
    val test=Test()
    println("Enter Data For Soduku")
    val sudokuBoard = Array(9) { Array(9) { "" } }
    for (i in 0 until 9) {
        println("Enter Row  ${i + 1}")
        val input = readLine()?.split(" ")?.map { it.trim() } ?: listOf()
        if (input.size != 9) {
            println("Check You Entered 9 cell")
            return
        }
        for (j in 0 until 9) {
            sudokuBoard[i][j] = input[j]
        }
    }

    val isValid = test.sudokuChecker(sudokuBoard)
    if (isValid) {
        println("Soduku Success")
    } else {
        println("Soduku Fail")
    }

}
