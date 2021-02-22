package p198;

/**
 * @author Glory
 * @date 2019/10/28 8:43
 */
public class Solution {

    public int rob(int[] nums) {
        int preMax = 0, curMax = 0;
        for (int x : nums) {
            int tmp = curMax;
            curMax = Math.max(preMax + x, curMax);
            preMax = tmp;
        }
        return curMax;
    }

}
