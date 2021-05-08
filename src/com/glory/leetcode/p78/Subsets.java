//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1160 👎 0

package com.glory.leetcode.p78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2021-05-08 10:02:15
 */
public class Subsets {

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int num : nums) {
                int all = res.size();
                for (int j = 0; j < all; j++) {
                    List<Integer> temp = new ArrayList<>(res.get(j));
                    temp.add(num);
                    res.add(temp);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{0, 1}));
    }

}