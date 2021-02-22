package p590;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/4/18 16:38
 */
public class Solution2 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            travel(res, root);
        }
        return res;
    }

    public void travel(List<Integer> res, Node node) {
        for (Node n : node.children) {
            travel(res, n);
        }
        res.add(node.val);
    }

}
