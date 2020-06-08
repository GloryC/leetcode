package p1365;

/**
 * @author Glory
 * @date 2020/3/4 15:17
 */
public class Solution {

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

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

}
