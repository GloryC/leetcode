package p70;

/**
 * @author Glory
 * @date 2020/3/6 14:46
 */
public class Solution {

//    private int digui(int i, int n) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        return digui(i + 1, n) + digui(i + 2, n);
//    }
//
//    public int climbStairs(int n) {
//        return digui(0, n);
//    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(6));

    }

}
