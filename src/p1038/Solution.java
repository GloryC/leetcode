package p1038;

import util.TreeNode;

/**
 * @author zhanggc
 * @date 2021/3/2 15:40
 */
public class Solution {

    private int sum = 0;

    /**
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
     * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     */
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

}
