package p912;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/31 14:00
 */
public class Solution2 {

    /**
     * count sort
     * 用base来抵除负数的影响
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int base = 50000;  // 最大负数的取值范围
        int[] count = new int[base * 2 + 1];
        for (int num : nums) {
            count[num + base]++;
        }
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[index++] = i - base;
                count[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {5, 1, 1, 2, 0, 0};
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.sortArray(data)));
    }

}
