//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 123 👎 0

package com.glory.leetcode.m1714;

import java.util.Arrays;

/**
 * @author zhanggc
 * @date 2021-09-03 16:25:34
 */
public class SmallestKLcci {

    static class Solution {
        public int[] smallestK(int[] arr, int k) {
            Arrays.sort(arr);
            return Arrays.copyOf(arr, k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }

}