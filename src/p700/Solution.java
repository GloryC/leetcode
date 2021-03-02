package p700;

import util.TreeNode;

/**
 * @author zhanggc
 * @date 2021/3/2 15:50
 */
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

}
