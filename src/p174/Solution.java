package p174;

/**
 * talk is cheap, show me the code
 *
 * @author Glory
 * @date 2020/7/12 19:27
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        // 这个数组表示在i,j位置骑士需要的最小生命值
        int[][] dp = new int[row][col];
        // 反向遍历
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) { //终点的情况
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == row - 1) { //最后一行的情况
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == col - 1) { //最后一列的情况
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        Solution solution = new Solution();
        System.out.println(solution.calculateMinimumHP(dungeon));
    }
}
