package per.zzy.rayleigh.leetcode.kotlin

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 */
object RomanNumber {

    private val romanMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    private val romanToIntMap = mapOf(
        1 to 'I',
        5 to 'V',
        10 to 'X',
        50 to 'L',
        100 to 'C',
        500 to 'D',
        1000 to 'M'
    )

    @JvmStatic
    fun main(args: Array<String>) {
        println(romanToInt("III"))
    }

    fun romanToInt(s: String): Int {
        var result = 0
        var lastChar = ' '
        for (c in s) {
            val currentValue = romanMap[c] ?: 0
            result += if ((lastChar == 'I' && (c == 'V' || c == 'X')) ||
                (lastChar == 'X' && (c == 'L' || c == 'C')) ||
                (lastChar == 'C' && (c == 'D' || c == 'M'))
            ) {
                currentValue - (romanMap[lastChar] ?: 0) * 2
            } else {
                currentValue
            }

            lastChar = c
        }


        return result
    }

    fun intToRoman(num: Int): String {
        val sb = StringBuilder()
        val romanPairs = listOf(
            1000 to 'M',
            900 to "CM",
            500 to 'D',
            400 to "CD",
            100 to 'C',
            90 to "XC",
            50 to 'L',
            40 to "XL",
            10 to 'X',
            9 to "IX",
            5 to 'V',
            4 to "IV",
            1 to 'I'
        )

        var remaining = num
        for ((value, roman) in romanPairs) {
            while (remaining >= value) {
                sb.append(roman)
                remaining -= value
            }
        }

        return sb.toString()
    }

}