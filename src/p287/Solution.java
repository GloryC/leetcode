package p287;

/**
 * @author Glory
 * @date 2020/5/26 8:42
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (count[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(nums));
    }
}
