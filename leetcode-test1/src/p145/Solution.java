package p145;

import util.TreeNode;

import java.util.*;

/**
 * @author Glory
 * @date 2020/4/18 16:11
 */
public class Solution {

    /**
     * 迭代法后序遍历，先写出反向遍历结果（根右左），再进行翻转
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

}
