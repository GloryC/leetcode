package p167;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/7/20 9:13
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return new int[]{};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(numbers, 10)));
    }
}
