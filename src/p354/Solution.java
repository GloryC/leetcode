package p354;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @author zhanggc
 * @date 2021/3/4 9:18
 */
public class Solution {

    /**
     * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
     * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * <p>
     * 比较naive的方法, 先按长排序, 然后按照O(N^2)的最长递增子序列的思想来做
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length, max = 1;
        if (n < 1) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Solution solution = new Solution();
        System.out.println(solution.maxEnvelopes(envelopes));
    }

}
