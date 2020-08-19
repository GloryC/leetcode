package p647;

/**
 * @author zhanggc
 * @date 2020/8/19 8:30
 */
public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                } else if (j - i == 1 && b) {
                    dp[i][j] = true;
                    count++;
                } else if (j - i > 1 && b && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("aaa"));
    }
}
