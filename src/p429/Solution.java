package p429;

import util.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Glory
 * @date 2020/6/29 15:52
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                assert node != null;
                level.add(node.val);
                List<Node> nodeList = node.children;
                for (Node child : nodeList) {
                    queue.offer(child);
                }
            }
            res.add(level);
        }
        return res;
    }
}
