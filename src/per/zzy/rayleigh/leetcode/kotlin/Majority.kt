package per.zzy.rayleigh.leetcode.kotlin

import java.util.*


/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
object Majority {

    // hash计数
    fun majorityElement(nums: IntArray): Int {
        val m = mutableMapOf<Int, Int>()
        if (nums.size == 1) return nums[0]
        val max = nums.size / 2
        for (i in nums) {
            var n = m[i]
            if (n == null) {
                m[i] = 1
            } else {
                m[i] = ++n
                if (n > max) {
                    return i
                }
            }
        }
        return 0
    }

    // 由于多数元素的数量超过n/2，所以排序后下表为n/2的数据一定是众数
    fun majorityElement2(nums: IntArray): Int {
        Arrays.sort(nums)
        return nums[nums.size / 2]
    }

}