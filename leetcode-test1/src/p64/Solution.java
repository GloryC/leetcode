package p64;

/**
 * @author Glory
 * @date 2020/3/10 12:54
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int len = grid.length;
        int depth = grid[0].length;
        int[][] dp = new int[len][depth];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < depth; j++) {
                // 在起点
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                // 在左边缘，上一次只能是下移
                else if (i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
                // 在上边缘，上一次只能是右移
                else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[len - 1][depth - 1];
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(data));
    }

}
