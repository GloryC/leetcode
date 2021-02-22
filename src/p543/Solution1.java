package p543;

import com.sun.jmx.snmp.SnmpNull;

/**
 * @author Glory
 * @date 2019/10/25 9:15
 */
public class Solution1 {

    private int max = 0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(leftDepth + rightDepth, max);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4, null, null);
        TreeNode b = new TreeNode(5, null, null);
        TreeNode c = new TreeNode(2, a, b);
        TreeNode d = new TreeNode(3, null, null);
        TreeNode e = new TreeNode(1, c, d);
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.diameterOfBinaryTree(null));
    }

}
