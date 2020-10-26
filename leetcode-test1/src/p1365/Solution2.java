package p1365;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/4 15:17
 */
public class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] result = new int[nums.length];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= 100; ++i) {
            // 求前缀和
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            // 取前缀和
            if (nums[i] > 0) {
                result[i] = count[nums[i] - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.smallerNumbersThanCurrent(nums)));
    }

}
