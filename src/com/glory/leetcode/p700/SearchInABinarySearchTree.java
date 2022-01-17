package com.glory.leetcode.p700;

import com.glory.leetcode.util.TreeNode;

/**
 * @author zhanggc
 * @date 2022-01-17 22:18:43
 */
public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }


    static class Solution {
        public TreeNode searchBST(TreeNode root, int target) {
            if (root == null) {
                return null;
            }

            // search in left-tree
            if (root.val > target) {
                return searchBST(root.left, target);
            }
            // search in right-tree
            if (root.val < target) {
                return searchBST(root.right, target);
            }
            return root;
        }
    }

}
