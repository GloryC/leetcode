package o11;

/**
 * @author Glory
 * @date 2020/7/22 8:30
 */
public class Solution3 {
    /**
     * 考虑原数组递增的特性，采用二分查找
     */
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        Solution3 solution = new Solution3();
        System.out.println(solution.minArray(numbers));
    }
}
