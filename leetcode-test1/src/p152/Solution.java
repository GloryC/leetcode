package p152;

/**
 * @author Glory
 * @date 2020/5/18 8:47
 */
public class Solution {
    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int res = 1;
            for (int j = i; j < nums.length; j++) {
                res *= nums[j];
                max = Math.max(max, res);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 0, -1};
        System.out.println(solution.maxProduct(nums));
    }
}
