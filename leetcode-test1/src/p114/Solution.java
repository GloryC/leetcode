package p114;

import util.TreeNode;

/**
 * @author Glory
 * @date 2020/8/2 13:52
 */
public class Solution {

    private TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }
}
