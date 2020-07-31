package m0803;

/**
 * @author zhanggc
 * @date 2020/7/31 17:08
 */
public class Solution {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        Solution solution = new Solution();
        System.out.println(solution.findMagicIndex(nums));
    }
}
