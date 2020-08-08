package p99;

import util.TreeNode;

/**
 * @author zhanggc
 * @date 2020/8/8 10:00
 */
public class Solution {
    private TreeNode t1, t2, pre;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}
