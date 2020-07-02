package p718;

/**
 * @author Glory
 * @date 2020/7/1 8:34
 */
public class Solution {
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        int result = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        Solution solution = new Solution();
        System.out.println(solution.findLength(A, B));
    }
}
