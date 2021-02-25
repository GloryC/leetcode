package p116;

/**
 * @author zhanggc
 * @date 2020/10/15 9:07
 */
public class Solution {

    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * <p>
     * 那么，我们的做法就是增加函数参数，一个节点做不到，我们就给他安排两个节点，
     * 「将每一层二叉树节点连接起来」可以细化成「将每两个相邻节点都连接起来」：
     */
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;

        /* 前序遍历位置 */
        // 将传入的两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}