package p32;

/**
 * @author Glory
 * @date 2020/6/24 9:08
 */
public class Solution2 {

    /**
     * 方法2，动态规划
     * 也就是字符串形如"……()"    dp[i]=dp[i−2]+2
     * 字符串形如 ``.......))"  dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 0;
        int[] dp = new int[chars.length];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                int before = i - dp[i - 1];
                if (chars[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (before > 0 && chars[before - 1] == '(') {
                    dp[i] = dp[i - 1] + (before >= 2 ? dp[before - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestValidParentheses("()(())"));
    }
}
