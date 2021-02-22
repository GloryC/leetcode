package p93;

/**
 * @author Glory
 * @date 2020/7/18 22:39
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] cs3 = s3.toCharArray();
        int m = cs1.length, n = cs2.length;
        if (m + n != cs3.length) return false;
        // 动态规划，dp[i,j]表示s1前i字符能与s2前j字符组成s3前i+j个字符
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m && cs1[i - 1] == cs3[i - 1]; i++) dp[i][0] = true;
        for (int j = 1; j <= n && cs2[j - 1] == cs3[j - 1]; j++) dp[0][j] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && cs3[i + j - 1] == cs1[i - 1]) ||
                        (dp[i][j - 1] && cs3[i + j - 1] == cs2[j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
