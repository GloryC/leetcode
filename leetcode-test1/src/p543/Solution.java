package p543;

/**
 * @author Glory
 * @date 2019/10/25 9:15
 */
public class Solution {

    private int result;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        depth(root);
        return result - 1;
    }

}
