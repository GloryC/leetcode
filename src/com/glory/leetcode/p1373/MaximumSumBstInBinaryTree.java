package com.glory.leetcode.p1373;

import com.glory.leetcode.util.TreeNode;

/**
 * @author zhanggc
 * @date 2022-01-19 23:26:06
 */
public class MaximumSumBstInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }


    static class Solution {
        // 全局变量，记录 BST 最大节点之和
        int maxSum = 0;

        public int maxSumBST(TreeNode root) {
            traverse(root);
            return maxSum;
        }

        /**
         * 如果当前节点要做的事情需要通过左右子树的计算结果推导出来，就要用到后序遍历。
         * <p>
         * res[0] 记录以 root 为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
         * <p>
         * res[1] 记录以 root 为根的二叉树所有节点中的最小值；
         * <p>
         * res[2] 记录以 root 为根的二叉树所有节点中的最大值；
         * <p>
         * res[3] 记录以 root 为根的二叉树所有节点值之和。
         */
        int[] traverse(TreeNode root) {
            if (root == null) {
                return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
            }

            // 递归计算左右子树
            int[] left = traverse(root.left);
            int[] right = traverse(root.right);

            // 后序遍历
            int[] res = new int[4];
            // 这个 if 在判断以 root 为根的二叉树是不是 BST
            if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
                // 以 root 为根的二叉树是 BST
                res[0] = 1;
                // 计算以 root 为根的这棵 BST 的最小值
                res[1] = Math.min(left[1], root.val);
                // 计算以 root 为根的这棵 BST 的最大值
                res[2] = Math.max(right[2], root.val);
                // 计算以 root 为根的这棵 BST 所有节点之和
                res[3] = left[3] + right[3] + root.val;
                // 更新全局变量
                maxSum = Math.max(maxSum, res[3]);
            } else {
                // 以 root 为根的二叉树不是 BST
                res[0] = 0;
                // 其他的值都没必要计算了，因为用不到
            }
            return res;
        }
    }

}
