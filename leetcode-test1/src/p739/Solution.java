package p739;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/11 8:34
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (T[i] < 100) {
                for (int j = i + 1; j < len; j++) {
                    if (T[j] > T[i]) {
                        res[i] = j - i;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(T)));
    }
}
