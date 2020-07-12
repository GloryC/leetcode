package p64;

/**
 * @author Glory
 * @date 2020/3/10 12:54
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        // use grid[][] as dp[][]
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(data));
    }

}
