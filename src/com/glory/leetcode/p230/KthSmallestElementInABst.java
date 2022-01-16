package com.glory.leetcode.p230;

import com.glory.leetcode.util.TreeNode;

/**
 * @author zhanggc
 * @date 2022-01-16 22:52:27
 */
public class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        // 记录结果
        int res = 0;
        // 记录当前元素的排名
        int rank = 0;

        public int kthSmallest(TreeNode root, int k) {
            traverse(root, k);
            return res;
        }

        void traverse(TreeNode root, int k) {
            if (root == null) {
                return;
            }

            traverse(root.left, k);
            rank++;
            if (k == rank) {
                res = root.val;
                return;
            }
            traverse(root.right, k);
        }
    }

}
