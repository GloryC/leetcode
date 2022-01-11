//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 942 👎 0

package com.glory.leetcode.p94;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2021-05-08 14:17:56
 */
public class BinaryTreeInorderTraversal {

    interface Solution {

        /**
         * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
         *
         * @param root 根节点
         * @return 中序遍历
         */
        List<Integer> inorderTraversal(TreeNode root);
    }


    /**
     * 方法1：回溯算法思路
     */
    static class Solution1 implements Solution {

        private LinkedList<Integer> res = new LinkedList<>();

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            traverse(root);
            return res;
        }

        /**
         * 二叉树遍历函数
         */
        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.left);
            // 中序遍历位置
            res.add(root.val);
            traverse(root.right);
        }

    }

    /**
     * 方法二：动态规划思路
     */
    static class Solution2 implements Solution {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            res.addAll(inorderTraversal(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
            return res;
        }

    }

}
