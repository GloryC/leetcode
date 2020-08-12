package p133;

import java.util.*;

/**
 * @author zhanggc
 * @date 2020/8/12 8:33
 */
public class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookup = new HashMap<>(16);
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node, Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors)
            clone.neighbors.add(dfs(n, lookup));
        return clone;
    }

    public Node cloneGraph2(Node node) {
        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        return clone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
