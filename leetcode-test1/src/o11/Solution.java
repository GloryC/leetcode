package o11;

/**
 * @author Glory
 * @date 2020/7/22 8:30
 */
public class Solution {
    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.minArray(numbers));
    }
}
