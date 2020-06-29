package p1161;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Glory
 * @date 2020/6/29 15:35
 */
public class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        int maxSum = root.val, level = 1, maxLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(), curSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                curSum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}
