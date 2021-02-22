package p169;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/13 18:34
 */
public class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {3, 2, 3};
        System.out.println(solution.majorityElement(data));
    }

}
