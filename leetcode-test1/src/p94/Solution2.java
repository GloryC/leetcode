package p94;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Glory
 * @date 2019/9/20 9:18
 */
public class Solution2 {

    /**
     * 递归中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> res = new LinkedList<>();
        travel(res, root);
        return res;
    }

    private void travel(List res, TreeNode node) {
        if (node.left != null) travel(res, node.left);
        res.add(node.val);
        if (node.right != null) travel(res, node.right);
    }

}
