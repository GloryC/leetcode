//有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。 
//
// 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为
//本次查询的结果。 
//
// 并返回一个包含给定查询 queries 所有结果的数组。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
//输出：[2,7,14,8] 
//解释：
//数组中元素的二进制表示形式是：
//1 = 0001 
//3 = 0011 
//4 = 0100 
//8 = 1000 
//查询的 XOR 值为：
//[0,1] = 1 xor 3 = 2 
//[1,2] = 3 xor 4 = 7 
//[0,3] = 1 xor 3 xor 4 xor 8 = 14 
//[3,3] = 8
// 
//
// 示例 2： 
//
// 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
//输出：[8,0,4,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10^4 
// 1 <= arr[i] <= 10^9 
// 1 <= queries.length <= 3 * 10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] <= queries[i][1] < arr.length 
// 
// Related Topics 位运算 
// 👍 71 👎 0

package com.glory.leetcode.p1310;

import java.util.Arrays;

/**
 * @author zhanggc
 * @date 2021-05-12 09:42:59
 */
public class XorQueriesOfASubarray {

    static class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int start = queries[i][0];
                int end = queries[i][1];
                res[i] = arr[start];
                for (int j = start + 1; j <= end; j++) {
                    res[i] ^= arr[j];
                }
            }
            return res;
        }
    }

    /**
     * 前缀异或
     */
    static class Solution2 {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int n = arr.length;
            int[] xors = new int[n + 1];
            for (int i = 0; i < n; i++) {
                xors[i + 1] = xors[i] ^ arr[i];
            }

            int m = queries.length;
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.xorQueries(new int[]{16}, new int[][]{
                {0, 0}, {0, 0}, {0, 0}
        })));
    }

}