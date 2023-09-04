package per.zzy.rayleigh.leetcode.kotlin

import per.zzy.rayleigh.leetcode.kotlin.Majority.majorityElement

object Tester {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(2,2,1,1,1,2,2)
        println("m=${majorityElement(nums)}")
    }

}