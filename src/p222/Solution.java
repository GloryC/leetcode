package p222;

import util.TreeNode;

/**
 * @author zhanggc
 * @date 2020/11/24 16:15
 */
public class Solution {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
