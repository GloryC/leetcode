package p5;

/**
 * @author Glory
 * @date 2020/5/21 8:49
 */
public class Solution {
    public String longestPalindrome(String s) {
        char[] data = s.toCharArray();
        int len = data.length;
        if (len < 2) return s;
        int maxLen = 1, begin = 0;

        // dp[i][j] 表示s[i]...s[j]是否为回文字符串
        // P(i,j)=P(i+1,j−1)∧(Si==Sj)
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 状态转移
        // 注意：先填左下角
        // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (data[i] != data[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1; // 回文串从哪里结束
                    begin = i; // 回文串从哪里开始
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("bbab"));
    }

}
