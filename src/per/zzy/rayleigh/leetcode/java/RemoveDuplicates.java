package per.zzy.rayleigh.leetcode.java;

import java.util.Arrays;

/**
 * 给你一个 升序排列 的数组 nums ，请你“原地”删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，
 * 你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
 * nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3}; // 输入数组
        int[] expectedNums = {0,0,1,1,2,3,3}; // 长度正确地期望答案

        int k = removeDuplicates2(nums); // 调用

        System.out.println("k=" + k);

        System.out.println("nums=" + Arrays.toString(nums));
    }


    /**
     * 时间 -ms 击败 100.00%使用 Java 的用户
     * 内存 41.64mb 击败 95.04%使用 Java 的用户
     */
    private static int removeDuplicates(int[] nums) {
        // 数组为空，直接返回
        if (nums.length == 0) return 0;
        // 特殊情况，可以直接计算
        int end = nums[nums.length - 1];
        int start = nums[0];
        if (end == start) {
            return 1;
        }
        // 普通情况
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j+1;
    }


    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * k 为需要保留的重复个数，可以自己调节
     */
    private static int removeDuplicates2(int[] nums) {
        // 数组为空，直接返回
        if (nums.length == 0) return 0;

        int k = 2;
        if (nums.length < k) return nums.length;
        int cnt = 1;
        // 普通情况
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
                cnt = 1; // index 清空
            } else {
                cnt ++;
                if (cnt <= k) {
                    j++;
                    nums[j] = nums[i];
                }
            }

            System.out.println("cnt=" + cnt + " nums[j]=" + nums[j] + " j=" + j);
        }

        return j+1;
    }

}
