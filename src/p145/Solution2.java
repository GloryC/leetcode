package p145;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/4/18 16:11
 */
public class Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) travel(res, root);
        return res;
    }

    private void travel(List<Integer> res, TreeNode node) {
        if (node.left != null) travel(res, node.left);
        if (node.right != null) travel(res, node.right);
        res.add(node.val);
    }

}
