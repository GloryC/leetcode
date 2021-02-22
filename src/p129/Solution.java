package p129;

import util.TreeNode;

/**
 * @author zhanggc
 * @date 2020/10/29 9:07
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int i) {
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return helper(root.left, temp) + helper(root.right, temp);
    }

}
