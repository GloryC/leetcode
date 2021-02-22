package p27;

/**
 * @author Glory
 * @date 2020/7/6 15:59
 */
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        Solution2 solution = new Solution2();
        System.out.println(solution.removeElement(nums, 3));
    }
}
