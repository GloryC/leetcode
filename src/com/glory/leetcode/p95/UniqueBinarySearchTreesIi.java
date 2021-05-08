//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 869 👎 0

package com.glory.leetcode.p95;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2021-05-08 14:29:25
 */
public class UniqueBinarySearchTreesIi {

    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n < 1) {
                return new ArrayList<>();
            }
            return helper(1, n);
        }

        private List<TreeNode> helper(int start, int end) {
            List<TreeNode> list = new ArrayList<>();

            if (start > end) {
                list.add(null);
                return list;
            }

            for (int i = start; i <= end; i++) {
                // 想想为什么这行不能放在这里，而放在下面？
                // TreeNode root = new TreeNode(i);
                List<TreeNode> left = helper(start, i - 1);
                List<TreeNode> right = helper(i + 1, end);

                // 固定左孩子，遍历右孩子
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }


}