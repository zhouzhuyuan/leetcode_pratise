package per.zzy.rayleigh.leetcode.kotlin

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
object Sudoku {

    @JvmStatic
    fun main(args: Array<String>) {
        val board = arrayOf(
            charArrayOf('.','.','4','.','.','.','6','3','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.'),
            charArrayOf('5','.','.','.','.','.','.','9','.'),
            charArrayOf('.','.','.','5','6','.','.','.','.'),
            charArrayOf('4','.','3','.','.','.','.','.','1'),
            charArrayOf('.','.','.','7','.','.','.','.','.'),
            charArrayOf('.','.','.','5','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','.','.','.','.')
            )


        println(isValidSudoku(board))
    }


    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val v = mutableMapOf<Int, MutableSet<Char>>()
        val f = mutableMapOf<String, MutableSet<Char>>()

        for (i in board.indices) {
            val h = mutableSetOf<Char>()

            val a = board[i]

            for (j in a.indices) {

                val cj = a[j]

                if (cj == '.') continue
                if (h.contains(cj)) return false
                else h.add(cj)

//                println("h:$i ha:${h}")

                var va = v[j]
                if (va != null) {
                    if (va.contains(cj)) return false
                    else {
                        va.add(cj)
                    }
                } else {
                    va = mutableSetOf()
                    va.add(cj)
                    v[j] = va
                }

//                println("v:$j va:${va}")

                val key = (i / 3).toString() + (j / 3).toString()
                var fa = f[key]
                if (fa != null) {
                    if (fa.contains(cj)) return false
                    else {
                        fa.add(cj)
                    }
                } else {
                    fa = mutableSetOf()
                    fa.add(cj)
                    f[key] = fa
                }

//                println("key:$key fa:${fa} \n ----------\n ")
            }
        }
        return true
    }

}