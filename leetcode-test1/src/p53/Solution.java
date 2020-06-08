package p53;

/**
 * @author Glory
 * @date 2019/10/24 16:58
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(data));
    }


}
