package p538;

import util.TreeNode;

/**
 * @author Glory
 * @date 2019/10/23 8:27
 */
public class Solution {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.right);
        // 维护累加和
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

}
