package m1716;

/**
 * @author Glory
 * @date 2020/3/6 14:40
 */
public class Solution {

    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] data = {2, 7, 9, 3, 1};
        Solution solution2 = new Solution();
        System.out.println(solution2.massage(data));
    }

}
