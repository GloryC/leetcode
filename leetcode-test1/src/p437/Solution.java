package p437;

/**
 * @author Glory
 * @date 2019/10/22 11:03
 */
public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int paths(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += paths(root.left, sum - root.val);
        res += paths(root.right, sum - root.val);
        return res;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return paths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

}