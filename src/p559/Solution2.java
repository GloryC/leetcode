package p559;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Glory
 * @date 2020/6/28 17:11
 */
public class Solution2 {

    /**
     * 层序遍历
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children.size() == 0) return 1;
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            depth++;
            while (count > 0) {
                Node node = queue.poll();
                assert node != null;
                if (node.children.size() != 0) {
                    queue.addAll(node.children);
                }
                count--;
            }
        }
        return depth;
    }
}
