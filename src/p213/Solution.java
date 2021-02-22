package p213;

/**
 * @author Glory
 * @date 2020/3/24 1:42
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i = 2; i <= nums.length - 2; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        for (int i = 3; i <= nums.length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }


        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 1, 1};
        Solution solution = new Solution();
        System.out.println(solution.rob(data));
    }

}
