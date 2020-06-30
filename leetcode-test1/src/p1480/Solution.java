package p1480;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/30 9:01
 */
public class Solution {
    public int[] runningSum(int[] nums) {
        if (nums.length == 0) return new int[0];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.runningSum(nums)));
    }
}
