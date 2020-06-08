package p837;

/**
 * @author Glory
 * @date 2020/6/3 8:45
 */
public class Solution {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + 1];
        double sum = 0;
        dp[0] = 1;
        if (K > 0) sum += 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = sum / W;
            if (i < K) sum += dp[i];
            if (i >= W) sum -= dp[i - W];
        }
        double ans = 0;
        for (int i = K; i <= N; i++)
            ans += dp[i];
        return ans;
    }
}
