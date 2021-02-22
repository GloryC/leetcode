package p1025;

/**
 * @author Glory
 * @date 2019/11/4 9:26
 */
public class Solution2 {
    public boolean divisorGame(int n) {
        int[] dp = new int[n + 1];
        if (n <= 1) {
            return false;
        } else {
            dp[1] = 0;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    if (i % j == 0 && dp[i - j] == 0) {
                        dp[i] = 1;
                        break;
                    }
                }
            }
        }
        return dp[n] == 1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.divisorGame(3));
    }
}