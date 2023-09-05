package per.zzy.rayleigh.leetcode.kotlin
object Tree {

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val r = mutableListOf<List<Int>>()
        var curLevel = mutableListOf<TreeNode>()
        if (root == null) return r
        curLevel.add(root)

        while (curLevel.isNotEmpty()) {
            val temp = curLevel
            curLevel = mutableListOf<TreeNode>()

            val tempList = mutableListOf<Int>()
            for (node in temp) {
                tempList.add(node.v)
                node.left?.let {
                    curLevel.add(it)
                }
                node.right?.let {
                    curLevel.add(it)
                }
            }
            r.add(tempList)
        }

        return r
    }

}