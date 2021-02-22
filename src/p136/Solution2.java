package p136;

/**
 * @author Glory
 * @date 2019/10/22 10:47
 */
public class Solution2 {

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.singleNumber(nums));
    }

}
