package p416;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/18 9:45
 */
public class Solution2 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;  // 奇数不要


        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution2 solution = new Solution2();
        System.out.println(solution.canPartition(nums));
    }
}
