package p739;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/11 8:34
 */
public class Solution2 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j += res[j]) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.dailyTemperatures(T)));
    }
}
