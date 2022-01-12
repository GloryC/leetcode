package com.glory.leetcode.p226;

import com.glory.leetcode.util.TreeNode;

/**
 * @author zhanggc
 * @date 2022-01-12 22:21:05
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    /**
     * 翻转一棵二叉树。
     */
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            /* ***前序遍历位置*** */
            // 对于 root 节点，需要交换它的左右子节点
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }

}
