package per.zzy.rayleigh.leetcode.kotlin

object MyNumbers {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(-1,0,1,2,-1,-4)

        println(threeSum(nums))
    }

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums\[i], nums\[j], nums\[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums\[i] + nums\[j] + nums\[k] == 0。
     * 请你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        nums.sort()

        for (i in nums.indices) {
            if (nums[i] > 0) break

            if (i > 0 && nums[i] == nums[i - 1]) continue

            var l = i + 1
            var r = nums.size - 1

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(listOf(nums[i], nums[l], nums[r]))
                    while (l < r && nums[l] == nums[l + 1]) {
                        l ++
                    }

                    while (l < r && nums[r] == nums[r - 1]) {
                        r --
                    }

                    l ++
                    r --
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l ++
                } else {
                    r --
                }


            }
        }


        return res
    }

}