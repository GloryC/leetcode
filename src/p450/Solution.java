package p450;

import util.TreeNode;

/**
 * @author zhanggc
 * @date 2021/3/2 15:59
 */
public class Solution {

    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
     * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // 处理情况 3，左右子树都不为空，必须找到左子树中最大的那个节点，或者右子树中最小的那个节点
            //  来接替自己。我们以第二种方式讲解。
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
