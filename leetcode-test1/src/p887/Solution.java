package p887;

import java.util.HashMap;

/**
 * @author Glory
 * @date 2020/4/11 18:45
 */
public class Solution {

    private HashMap<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    private int dp(int K, int N) {
        if (K == 1) return N;
        if (N == 0) return 0;
        if (memo.containsKey(K + "+" + N)) {
            return memo.get(K + "+" + N);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
        }
        memo.put(K + "+" + N, res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.superEggDrop(2, 6));
    }
}
