package p104;

import util.TreeNode;

/**
 * @author Glory
 * @date 2019/12/11 9:52
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
