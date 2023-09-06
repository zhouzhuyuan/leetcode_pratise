package per.zzy.rayleigh.leetcode.java;

public class Test {
    public static void main(String[] args) {

    }


    public static int found(int[] array, int left, int right, int target) {
        int index = (right + left) / 2;
        if (left >= right && array[index] != target) return -1;
        if (array[index] < target) {
            return found(array, index + 1, right, target);
        } else if (array[index] > target) {
            return found(array, left, index - 1, target);
        }
        return index;
    }

}
