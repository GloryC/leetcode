package o11;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/7/22 8:30
 */
public class Solution2 {
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        Solution2 solution = new Solution2();
        System.out.println(solution.minArray(numbers));
    }
}
