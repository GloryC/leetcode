package p589;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Glory
 * @date 2020/4/18 16:30
 */
public class Solution {

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

    /**
     * 迭代前序遍历
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root ==null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            List<Node> nodeList = node.children;
            Collections.reverse(nodeList);
            for (Node n: nodeList) {
                stack.push(n);
            }
        }
        return res;
    }

}