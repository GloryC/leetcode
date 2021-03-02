package p98;

import util.TreeNode;

/**
 * @author Glory
 * @date 2020/4/20 15:35
 */
public class Solution {

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * BST的中序遍历是有序递增
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
     */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

}
