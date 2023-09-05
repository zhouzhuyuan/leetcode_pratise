package per.zzy.rayleigh.leetcode.kotlin

import java.sql.SQLOutput
import kotlin.math.max
import kotlin.math.min

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
object Jumper {

    /**
     * 先计算出当前能达到的最大下标，然后开始遍历，如果遍历的下标没有超过当前的最大值，说明当前位置是可达的
     * 然后根据当前位置计算出最新的最远可达下标，如果没有超过之前的下标，那就不更新，超过那就说明最新最大值前的位置都可达
     * 知道最大可达距离超过数组长度，那就是可达的
     * 如果发现下标超过了最大可达距离，那说明之后的位置都不可达
     */
    fun canJump(nums: IntArray): Boolean {
        var maxJump = 0
        for (i in nums.indices) {
            if (i > maxJump) return false
            maxJump = max(maxJump, i + nums[i])
        }
        return true
    }

    // 递归，超时
    fun jumpExp(index: Int, nums: IntArray): Boolean {
        if (index == nums.size - 1) return true
        if (index >= nums.size) return false
        val value = nums[index]
        for (i in value downTo 1) {
            if (jumpExp(index + i, nums)) {
                return true
            }
        }
        return false
    }

    // 升级，找出最少需要跳几下
    // 动态规划，得出到当前位置的最少跳数
    // 我这边从上一跳计算出下一跳的距离
    fun jump(nums: IntArray): Int {
//  原版本
//        if (nums.size == 1) return 0
//        var curMaxDis = 0
//        var nextMaxDis = 0
//        var minStep = 0
//
//        for (i in nums.indices) {
//            if (i > curMaxDis) {
//                minStep ++
//                curMaxDis = nextMaxDis
//            }
//
//            nextMaxDis = max(nextMaxDis, i + nums[i])
//
//            if (nextMaxDis >= nums.size - 1) {
//                minStep ++
//                break
//            }
//
//        }
//
//        return minStep
        if (nums.size == 1) return 0
        var curMaxDis = 0
        var nextMaxDis = 0
        var minStep = 0
        for (i in nums.indices) {
            nextMaxDis = max(nextMaxDis, i + nums[i])
            if (nextMaxDis >= nums.size - 1) {
                minStep ++
                break
            }
            if (i == curMaxDis) {
                minStep ++
                curMaxDis = nextMaxDis
            }
        }
        return minStep
    }

}