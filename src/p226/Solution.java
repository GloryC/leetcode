package p226;

import util.TreeNode;

/**
 * @author Glory
 * @date 2019/10/15 9:10
 */
public class Solution {

    /**
     * 翻转一棵二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
