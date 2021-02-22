package p297;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Glory
 * @date 2020/6/16 8:54
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode != null) {
                res.add(curNode.val);
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            } else {
                res.add(null);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] preStr = data.substring(1, data.length() - 1).split(",");
        Integer[] bfsOrder = new Integer[preStr.length];
        for (int i = 0; i < preStr.length; i++) {
            if (preStr[i].trim().equals("null")) {
                bfsOrder[i] = null;
            } else {
                bfsOrder[i] = Integer.parseInt(preStr[i].trim());
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        assert bfsOrder[0] != null;
        TreeNode root = new TreeNode(bfsOrder[0]);
        int cur = 1;//通过 cur 指针依次给节点赋值
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (bfsOrder[cur] != null) {
                curNode.left = new TreeNode(bfsOrder[cur]);
                queue.add(curNode.left);
            }
            cur++;
            if (bfsOrder[cur] != null) {
                curNode.right = new TreeNode(bfsOrder[cur]);
                queue.add(curNode.right);
            }
            cur++;
        }
        return root;
    }

}