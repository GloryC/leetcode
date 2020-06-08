package p98;

import util.TreeNode;

/**
 * @author Glory
 * @date 2020/4/20 15:35
 */
public class Solution {

    private boolean res;

    /**
     * BST的中序遍历是有序递增
     */
    public boolean isValidBST(TreeNode root) {
        return recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recur(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return recur(node.left, min, node.val) && recur(node.right, node.val, max);
    }

}
