package per.zzy.rayleigh.leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);

        while (!curLevel.isEmpty()) {
            List<TreeNode> temp = curLevel;
            curLevel = new ArrayList<TreeNode>();
            List<Integer> values = new ArrayList<>();
            for (TreeNode node : temp) {
                values.add(node.val);
                if (node.left != null) {
                    curLevel.add(node.left);
                }

                if (node.right != null) {
                    curLevel.add(node.right);
                }
            }

            result.add(values);
        }

        return result;
    }

    // 使用队列，优化
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.offer(root);

        while (!curLevel.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            int size = curLevel.size();


            for (int i = 0; i < size; i++) {
                TreeNode node = curLevel.poll();
                if (node != null) {
                    values.add(node.val);

                    if (node.left != null) {
                        curLevel.offer(node.left);
                    }

                    if (node.right != null) {
                        curLevel.offer(node.right);
                    }

                }
            }
            result.add(values);
        }

        return result;
    }


}
