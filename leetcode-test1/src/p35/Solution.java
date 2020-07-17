package p35;

/**
 * @author Glory
 * @date 2020/7/17 8:42
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, 0));
    }
}
