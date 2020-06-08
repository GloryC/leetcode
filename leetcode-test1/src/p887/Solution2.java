package p887;

import java.util.Arrays;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * @author Glory
 * @date 2020/4/11 18:45
 */
public class Solution2 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int n = 1; n <= N; n++) {
            dp[1][n] = n;
        }
        for (int k = 2; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                // dp[k][n] 表示k个鸡蛋、n个楼层时的最小移动次数。
                // 即 dp[k][n] = min(1 + Math.max(dp[k][n - i], dp[k - 1][i - 1])); 1 <= i <= n。
                // i 增大，dp[k][n - i]减小，dp[k - 1][i - 1]增大。
                // 于是找到第 1 个 i 使得 dp[k][n - i] <= dp[k - 1][i - 1]。
                int lo = 1, hi = n, mid = 0;
                while (lo + 1 < hi) {
                    mid = (lo + hi) >> 1;
                    if (dp[k][n - mid] < dp[k - 1][mid - 1]) {
                        hi = mid;
                    } else if (dp[k][n - mid] > dp[k - 1][mid - 1]) {
                        lo = mid;
                    } else {
                        lo = hi = mid;
                    }
                }
                dp[k][n] = 1 + dp[k][n - lo];
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.superEggDrop(3, 14));
    }
}
