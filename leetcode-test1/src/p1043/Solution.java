package p1043;

/**
 * @author Glory
 * @date 2020/6/29 16:01
 */
public class Solution {

    /**
     * dp[i]代表从i到最后的所有数字组合的最大和，向前遍历，增加一个数字A[i-1].
     * 那么dp[i-1]最优解可能是
     * <p>
     * A[i-1]单独做一组，加上dp[i]
     * 从后面拿一个{A[i-1],A[i]}组成一组，加上dp[i+1]
     * 从后面拿两个...
     * 最多从后面拿k-1个，加上剩下的dp[i-k+1]
     */
    public int maxSumAfterPartitioning(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len + 1];
        dp[len - 1] = A[len - 1];
        int maxNum, maxSum;
        for (int i = len - 2; i >= 0; i--) {
            maxNum = A[i];
            maxSum = A[i] + dp[i + 1];
            for (int j = 1; j < K && i + j < len; j++) {
                maxNum = Math.max(maxNum, A[i + j]);
                maxSum = Math.max(maxSum, maxNum * (j + 1) + dp[i + j + 1]);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] A = {1, 15, 7, 9, 2, 5, 10};
        Solution solution = new Solution();
        System.out.println(solution.maxSumAfterPartitioning(A, 3));
    }
}