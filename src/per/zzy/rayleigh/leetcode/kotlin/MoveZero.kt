package per.zzy.rayleigh.leetcode.kotlin

object MoveZero {

    @JvmStatic
    fun main(args: Array<String>) {
        moveZeroes(intArrayOf(0))
    }


    fun moveZeroes(nums: IntArray) {

        var zeroLocation = -1

        for (i in nums.indices) {
            val n = nums[i]

            if (n == 0 && zeroLocation == -1) {
                zeroLocation = i
                continue
            }

            if (n != 0) {
                nums[i] = nums[zeroLocation]
                nums[zeroLocation] = n
                zeroLocation ++
            }
        }

        println(nums.toList().toString())

    }

}