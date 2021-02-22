package p983;

/**
 * @author Glory
 * @date 2020/5/6 11:46
 */
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int last = days[len - 1];//最后一天
        int[] dp = new int[last + 1];//dp[i]表示第i天最便宜的花费
        int pos = 0;
        for (int i = 1; i <= last; i++) {
            if (i == days[pos]) {
                int day1 = i - 1;
                int day2 = Math.max(i - 7, 0);
                int day3 = Math.max(i - 30, 0);
                dp[i] = Math.min(dp[day1] + costs[0], Math.min(dp[day2] + costs[1], dp[day3] + costs[2]));
                pos++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[last];
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        Solution solution = new Solution();
        System.out.println(solution.mincostTickets(days, costs));

    }
}
