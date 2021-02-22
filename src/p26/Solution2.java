package p26;

/**
 * @author Glory
 * @date 2020/4/16 20:03
 */
public class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] data = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution2 solution = new Solution2();
        System.out.println(solution.removeDuplicates(data));
    }
}
