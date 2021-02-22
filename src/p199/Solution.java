package p199;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Glory
 * @date 2020/4/22 15:52
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        int cnt, tmp = 0;
        TreeNode node;
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            cnt = queue.size();
            while (cnt > 0) {
                node = queue.poll();
                assert node != null;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                cnt--;
                tmp = node.val;
            }
            res.add(tmp);
        }
        return res;
    }
}
