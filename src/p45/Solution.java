package p45;

/**
 * @author Glory
 * @date 2020/5/4 13:36
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int reach = 0;
        int nextReach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextReach = Math.max(i + nums[i], nextReach);
            if (nextReach >= nums.length - 1) return step + 1;
            if (i == reach) {
                step++;
                reach = nextReach;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1};
        Solution solution = new Solution();
        System.out.println(solution.jump(nums));
    }

}
