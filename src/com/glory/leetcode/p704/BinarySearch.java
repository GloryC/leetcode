package com.glory.leetcode.p704;

/**
 * @author zhanggc
 * @date 2022-02-24 21:58:05
 */
public class BinarySearch {

    static class Solution {
        /**
         * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
         * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
         */
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 9));
    }


}
