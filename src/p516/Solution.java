package p516;

/**
 * @author Glory
 * @date 2020/6/19 9:31
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 反向遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (ch[i] == ch[j]) {
                    // 水平伸缩
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 水平伸缩的最大值
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }

}
