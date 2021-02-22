package p111;

import util.TreeNode;

/**
 * @author zhanggc
 * @date 2020/8/21 8:55
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }

        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
