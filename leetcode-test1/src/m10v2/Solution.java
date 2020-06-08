package m10v2;

/**
 * @author Glory
 * @date 2020/6/1 9:05
 */
public class Solution {
    public int numWays(int n) {
        if (n <= 1) return 1;
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[0] = 1;
        for (int i = 2; i <= n; i++) {
            steps[i] = (steps[i - 1] + steps[i - 2]) % 1000000007;
        }

        return steps[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(92));
    }
}
