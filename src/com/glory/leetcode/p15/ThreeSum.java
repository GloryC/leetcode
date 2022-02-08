package com.glory.leetcode.p15;

import java.util.*;

/**
 * @author zhanggc
 * @date 2022-02-08 21:36:43
 */
public class ThreeSum {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 1. 排序
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new LinkedList<>();

            // 穷举 threeSum 的第一个数
            for (int i = 0; i < n; i++) {
                List<List<Integer>> tuples = twoSumTarget(nums, i + 1, -nums[i]);
                // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
                for (List<Integer> tuple : tuples) {
                    tuple.add(nums[i]);
                    res.add(tuple);
                }
                // 跳过第一个数字重复的情况，否则会出现重复结果
                while (i < n - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            return res;
        }

        private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
            // nums 数组必须有序
            int lo = start, hi = nums.length - 1;
            List<List<Integer>> res = new LinkedList<>();
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
