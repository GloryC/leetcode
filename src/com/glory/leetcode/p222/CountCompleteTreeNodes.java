package com.glory.leetcode.p222;

import com.glory.leetcode.util.TreeNode;

/**
 * @author zhanggc
 * @date 2022-01-15 22:30:34
 */
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }


    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     */
    static class Solution {
        public int countNodes(TreeNode root) {
            TreeNode l = root, r = root;
            // member the height of the left subtree and the right subtree
            int hl = 0, hr = 0;
            while (l != null) {
                l = l.left;
                hl++;
            }
            while (r != null) {
                r = r.right;
                hr++;
            }

            // if the heights of those are same, shows that it's a perfect tree
            if (hl == hr) {
                return (int) Math.pow(2, hl) - 1;
            }

            // if the heights are different, returns with the normal binary tree
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

}
