package per.zzy.rayleigh.leetcode.java;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        long start = System.currentTimeMillis();
        rotate3(nums, k);
        System.out.println("cost: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int r = k % nums.length;
        System.out.println(r);
        if (r == 0) return;
        int[] buf = new int[k];
        int i = nums.length - r - 1;
        System.arraycopy(nums, nums.length - r, buf, 0, r);

        while (i >= 0) {
            nums[i + r] = nums[i];
            i --;
        }
        System.arraycopy(buf, 0, nums, 0, r);

    }

    public static void rotate2(int[] nums, int k) {
        int l = nums.length;
        int[] buf = new int[l];
        for (int i = 0; i < l; i++) {
            buf[(i + k) % l] = nums[i]; // 用额外的数组，先将元素放到正确的位置，最后拷贝
        }
        System.arraycopy(buf, 0, nums, 0, l);
    }


    // 上次revert数组可以完成
    public static void rotate3(int[] nums, int k) {
        int r = k % nums.length;
        revertArrays(nums, 0, nums.length - 1);
        revertArrays(nums, 0, r - 1);
        revertArrays(nums, r, nums.length - 1);
    }

    private static void revertArrays(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

}
