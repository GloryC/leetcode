package p167;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/7/20 9:13
 */
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.twoSum(numbers, 9)));
    }
}
