package p892;

/**
 * @author Glory
 * @date 2020/3/25 0:08
 */
public class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int level = grid[i][j];  // 层数
                if (level > 0) {
                    area += level * 4 + 2;
                    // 减掉 i 与 i-1 相贴的两份表面积
                    area -= i > 0 ? Math.min(level, grid[i - 1][j]) * 2 : 0;
                    // 减掉 j 与 j-1 相贴的两份表面积
                    area -= j > 0 ? Math.min(level, grid[i][j - 1]) * 2 : 0;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2}, {3, 4}};
        Solution solution = new Solution();
        System.out.println(solution.surfaceArea(data));
    }

}
