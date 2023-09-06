package per.zzy.rayleigh.leetcode.kotlin
object MyString {

    @JvmStatic
    fun main(args: Array<String>) {
        println(isPalindrome2("0p"))
    }

    /**
     * 判断数字字母是不是回文串
     */
    fun isPalindrome(s: String): Boolean {
        val str = s.lowercase()
        val c = str.toCharArray()

        var left = 0
        var right = c.size - 1

        while (left <= right) {
            println("l:${c[left]} r:${c[right]}")
            while ((c[left] < 'a' || c[left] > 'z') && (c[left] < '0' || c[left] > '9')) {
                left ++
                if (left > c.size - 1) {
                    return true
                }
            }

            while ((c[right] < 'a' || c[right] > 'z') && (c[right] < '0' || c[right] > '9')) {
                right --
            }

            if (c[left] != c[right]) return false

            left ++
            right --
        }

        return true
    }

    // 优化
    fun isPalindrome2(s: String): Boolean {
        var l = 0
        var r = s.length - 1

        while (l <= r) {
            while (l < r && !s[l].isLetterOrDigit()) l++
            while (l < r && !s[r].isLetterOrDigit()) r--
            if (s[l].lowercase() != s[r].lowercase()) return false
            l++
            r--
        }

        return true
    }

}