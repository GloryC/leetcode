package p1248;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/4/21 15:19
 */
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -0;
        int ans = 0, sum = 0;
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        for (int i : nums) {
            sum += i & 1;
            map[sum]++;
            if (sum >= k) ans += map[sum - k];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = {1, 1, 2, 1, 1};
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubarrays(data, 3));
    }
}
