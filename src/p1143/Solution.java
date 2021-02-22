package p1143;

/**
 * @author Glory
 * @date 2020/6/18 16:30
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int m = c1.length, n = c2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    // 找到一个相同的字符
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 没找到字符，看删除谁后可重复的数量大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abc", "def"));
    }
}
