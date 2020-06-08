package p283;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2019/10/22 10:56
 */
public class Solution2 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 0, 3, 2, 0};
        Solution2 solution2 = new Solution2();
        solution2.moveZeroes(data);
        System.out.println(Arrays.toString(data));
    }

}
