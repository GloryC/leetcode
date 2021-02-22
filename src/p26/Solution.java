package p26;

/**
 * @author Glory
 * @date 2020/4/16 20:03
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] data = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(data));
    }
}
