package per.zzy.rayleigh.leetcode.kotlin

import kotlin.math.min

object Slider {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(2,3,1,2,4,3)
        println(minSubArrayLen(7, nums))
    }



    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minLength = Int.MAX_VALUE

        if (nums.size == 1) {
            return if (nums[0] == target) 1 else 0
        }

        var l = 0
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            while (l <= i && sum >= target) {
                if (sum == target) {
                    minLength = min(minLength, i - l + 1)
                }
                sum -= nums[l]
                l++
            }
        }

        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }

}