package p887;

/**
 * @author Glory
 * @date 2020/4/11 18:45
 */
public class Solution2 {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.superEggDrop(2, 6));
    }
}
