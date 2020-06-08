package p238;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/4 8:48
 */
public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] data = new int[nums.length];
        int left = 1, right = 1;
        Arrays.fill(data, 1);
        for (int i = 0; i < nums.length; i++) {
            data[i] *= left;
            left *= nums[i];

            data[nums.length - i - 1] *= right;
            right *= nums[nums.length - i - 1];
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4};
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.productExceptSelf(data)));
    }

}
