package p283;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2019/10/22 10:56
 */
public class Solution3 {

    public void moveZeroes(int[] nums) {
        int p = removeElement(nums, 0);
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    private int removeElement(int[] nums, int val) {
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
        int[] data = {1, 0, 3, 2, 0};
        Solution3 solution2 = new Solution3();
        solution2.moveZeroes(data);
        System.out.println(Arrays.toString(data));
    }

}
