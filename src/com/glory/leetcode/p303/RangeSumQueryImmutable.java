package com.glory.leetcode.p303;

/**
 * @author zhanggc
 * @date 2022-02-14 21:51:59
 */
public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{3, 5, 2, -2, 4, 1});
        System.out.println(numArray);
    }

    /**
     * 重点知识：前缀和
     */
    static class NumArray {

        // 前缀和数组
        private int[] preSum;

        public NumArray(int[] nums) {
            // preSum[0] = 0，便于计算累加和
            // 长度比nums.length多1, preSum[nums.length] = sum(nums)
            preSum = new int[nums.length + 1];
            // 计算 nums 的累加和
            for (int i = 1; i < nums.length + 1; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        /**
         * 查询闭区间 [left, right] 的累加和
         */
        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }

}
