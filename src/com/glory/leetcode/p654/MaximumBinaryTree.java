package com.glory.leetcode.p654;

import com.glory.leetcode.util.TreeNode;

/**
 * @author zhanggc
 * @date 2022-01-14 22:58:16
 */
public class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }


    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return traverse(nums, 0, nums.length - 1);
        }

        /**
         * 将 nums[lo..hi] 构造成符合条件的树，返回根节点
         */
        TreeNode traverse(int[] nums, int lo, int hi) {
            // base case
            if (lo > hi) {
                return null;
            }

            // 找到数组中的最大值和对应的索引
            int index = -1, maxVal = Integer.MIN_VALUE;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] > maxVal) {
                    index = i;
                    maxVal = nums[i];
                }
            }

            TreeNode root = new TreeNode(maxVal);
            root.left = traverse(nums, lo, index - 1);
            root.right = traverse(nums, index + 1, hi);
            return root;
        }

    }

}
