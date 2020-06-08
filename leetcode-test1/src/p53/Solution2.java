package p53;

/**
 * @author Glory
 * @date 2019/10/24 16:58
 */
public class Solution2 {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = {1};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.maxSubArray(data));
    }

}
