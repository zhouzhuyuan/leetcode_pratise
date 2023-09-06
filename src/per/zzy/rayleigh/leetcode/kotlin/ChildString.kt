package per.zzy.rayleigh.leetcode.kotlin

object ChildString {

    @JvmStatic
    fun main(args: Array<String>) {
        val s = "axc"
        val t = "ahbgdc"
        println(isSubsequence(s, t))
    }


    fun isSubsequence(s: String, t: String): Boolean {
        // 边界
        if (s.isEmpty()) return true
        if (s.length > t.length) return false
        if (s.length == t.length) return s == t

        var sIndex = 0
        var tIndex = 0
        while (tIndex < t.length) {
            if (t[tIndex] == s[sIndex]) {
                sIndex ++
                if (sIndex == s.length) return true
            }
            tIndex ++

            // 剩余长度已经不足了，直接跳出
            if (t.length - tIndex < s.length - sIndex) {
                break
            }
        }
        return false
    }
}