package p144;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/4/18 15:56
 */
public class Solution2 {

    /**
     * 递归前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            travel(res, root);
        }
        return res;
    }

    private void travel(List<Integer> res, TreeNode node) {
        res.add(node.val);
        if (node.left != null) travel(res, node.left);
        if (node.right != null) travel(res, node.right);
    }

}
