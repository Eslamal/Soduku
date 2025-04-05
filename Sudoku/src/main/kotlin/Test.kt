import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class Test {

    fun testValidSudoku3x3() {
        val validSudoku = arrayOf(
            arrayOf("5", "3", "4", "6", "7", "8", "9", "1", "2"),
            arrayOf("6", "7", "2", "1", "9", "5", "3", "4", "8"),
            arrayOf("1", "9", "8", "3", "4", "2", "5", "6", "7"),
            arrayOf("8", "5", "9", "7", "6", "1", "4", "2", "3"),
            arrayOf("4", "2", "6", "8", "5", "3", "7", "9", "1"),
            arrayOf("7", "1", "3", "9", "2", "4", "8", "5", "6"),
            arrayOf("9", "6", "1", "5", "3", "7", "2", "8", "4"),
            arrayOf("2", "8", "7", "4", "1", "9", "6", "3", "5"),
            arrayOf("3", "4", "5", "2", "8", "6", "1", "7", "9")
        )
        println(sudokuChecker(validSudoku))
    }

    fun testInvalidSudoku3x3Row() {
        val invalidSudoku = arrayOf(
            arrayOf("5", "3", "4", "6", "7", "8", "9", "1", "2"),
            arrayOf("6", "7", "2", "1", "9", "5", "3", "4", "8"),
            arrayOf("1", "9", "8", "3", "4", "2", "5", "6", "7"),
            arrayOf("8", "5", "9", "7", "6", "1", "4", "2", "3"),
            arrayOf("4", "2", "6", "8", "5", "3", "7", "9", "1"),
            arrayOf("7", "1", "3", "9", "2", "4", "8", "5", "6"),
            arrayOf("9", "6", "1", "5", "3", "7", "2", "8", "4"),
            arrayOf("2", "8", "7", "4", "1", "9", "6", "3", "5"),
            arrayOf("3", "4", "5", "2", "8", "6", "1", "7", "9")
        )
        invalidSudoku[0][0] = "5"     // repeat 5 in First row
        println(sudokuChecker(invalidSudoku))
    }

    fun testInvalidSudoku3x3Column() {
        val invalidSudoku = arrayOf(
            arrayOf("5", "3", "4", "6", "7", "8", "9", "1", "2"),
            arrayOf("6", "7", "2", "1", "9", "5", "3", "4", "8"),
            arrayOf("1", "9", "8", "3", "4", "2", "5", "6", "7"),
            arrayOf("8", "5", "9", "7", "6", "1", "4", "2", "3"),
            arrayOf("4", "2", "6", "8", "5", "3", "7", "9", "1"),
            arrayOf("7", "1", "3", "9", "2", "4", "8", "5", "6"),
            arrayOf("9", "6", "1", "5", "3", "7", "2", "8", "4"),
            arrayOf("2", "8", "7", "4", "1", "9", "6", "3", "5"),
            arrayOf("3", "4", "5", "2", "8", "6", "1", "7", "9")
        )
        invalidSudoku[0][0] = "6"  // repeat 6 in First column
        println(sudokuChecker(invalidSudoku))
    }

    fun testInvalidSudoku3x3Subgrid() {
        val invalidSudoku = arrayOf(
            arrayOf("5", "3", "4", "6", "7", "8", "9", "1", "2"),
            arrayOf("6", "7", "2", "1", "9", "5", "3", "4", "8"),
            arrayOf("1", "9", "8", "3", "4", "2", "5", "6", "7"),
            arrayOf("8", "5", "9", "7", "6", "1", "4", "2", "3"),
            arrayOf("4", "2", "6", "8", "5", "3", "7", "9", "1"),
            arrayOf("7", "1", "3", "9", "2", "4", "8", "5", "6"),
            arrayOf("9", "6", "1", "5", "3", "7", "2", "8", "4"),
            arrayOf("2", "8", "7", "4", "1", "9", "6", "3", "5"),
            arrayOf("3", "4", "5", "2", "8", "6", "1", "7", "9")
        )
        invalidSudoku[0][0] = "5"  // repeat 5 in box 3*3
        println(sudokuChecker(invalidSudoku))
    }
    fun sudokuChecker(board: Array<Array<String>>): Boolean {
        val size = board.size

        if (size != 9 || board.any { it.size != 9 }) {
            return false // Must be a 9x9 board
        }

        for (row in board) {
            val rowSet = mutableSetOf<String>()
            for (num in row) {
                if (num != "-" && !rowSet.add(num)) {
                    return false
                }
            }
        }
        for (col in 0 until size) {
            val colSet = mutableSetOf<String>()
            for (row in 0 until size) {
                val num = board[row][col]
                if (num != "-" && !colSet.add(num)) {
                    return false
                }
            }
        }

        val subgridSize = Math.sqrt(size.toDouble()).toInt()
        for (i in 0 until size step subgridSize) {
            for (j in 0 until size step subgridSize) {
                val subgridSet = mutableSetOf<String>()
                for (x in 0 until subgridSize) {
                    for (y in 0 until subgridSize) {
                        val num = board[i + x][j + y]
                        if (num != "-" && !subgridSet.add(num)) {
                            return false
                        }
                    }
                }
            }
        }

        return true
    }
}
