package p912;

import util.QuickSort;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/31 14:00
 */
public class Solution {

    public int[] sortArray(int[] nums) {
        QuickSort.sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int[] data = {5, 1, 1, 2, 0, 0};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArray(data)));
    }

}
