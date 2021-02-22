package p238;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/4 8:48
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i!=j){
                    sum*= nums[j];
                }
            }
            data[i] = sum;
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(data)));
    }

}
