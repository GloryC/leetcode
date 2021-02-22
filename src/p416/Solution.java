package p416;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/18 9:45
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }
}
