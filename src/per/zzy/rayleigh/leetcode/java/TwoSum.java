package per.zzy.rayleigh.leetcode.java;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {

    }

    /**
     * 暴力
     * 执行结果：通过
     * 执行用时：49 ms, 在所有 Java 提交中击败了40.29%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了72.86%的用户
     * 通过测试用例：57 / 57
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length ; i ++) {
            int v1 = nums[i];
            for (int j = i + 1; j < nums.length; j ++) {
                int v2 = nums[j];
                if (v1 + v2 == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }


    /**
     * 空间换时间
     * 执行结果：通过
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.55%的用户
     * 内存消耗：42 MB, 在所有 Java 提交中击败了9.65%的用户
     * 通过测试用例：57 / 57
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dep = new HashMap<>();
        for (int i = 0 ; i < nums.length; i ++) {
            Integer o = dep.get(target - nums[i]);
            if (o != null) {
                return new int[]{o, i};
            } else {
                dep.put(nums[i], i);
            }
        }
        return null;
    }

}
