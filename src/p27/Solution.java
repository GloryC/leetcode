package p27;

/**
 * @author Glory
 * @date 2020/7/6 15:59
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, 3));
    }
}
