package p55;

/**
 * @author Glory
 * @date 2020/4/17 14:44
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; k < nums.length - 1; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] data = {0};
        Solution solution = new Solution();
        System.out.println(solution.canJump(data));
    }
}
