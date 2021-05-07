//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1845 👎 0

package com.glory.leetcode.p136;

/**
 * @author zhanggc
 * @date 2021-05-07 15:43:56
 */
public class SingleNumber {

    static class Solution {
        public int singleNumber(int[] nums) {
            int a = 0;
            for (int num : nums) {
                a ^= num;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{1, 2, 3, 4, 2, 3, 4}));
    }

}