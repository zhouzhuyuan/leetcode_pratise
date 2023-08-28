package per.zzy.rayleigh.leetcode.java;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElements {

    public static void main(String[] args) {

        int[] nums = {2};
        int val = 2;

        System.out.println(removeElement(nums, val));

        System.out.println(Arrays.toString(nums));

    }


    /**
     * 时间 0ms 击败 100.00%使用 Java 的用户
     * 内存 38.93MB 击败 76.93%使用 Java 的用户
     */
    public static int removeElement(int[] nums, int val) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != j) { // 优化一：当下标相同时，不进行赋值操作
                    nums[j] = nums[i];
                }
                j++;
            }
        }


        return j;
    }

}
