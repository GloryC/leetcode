package p695;

/**
 * @author Glory
 * @date 2020/3/15 1:09
 */
public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0, high = grid.length, width = grid[0].length;
        for (int x = 0; x < high; x++) {
            for (int y = 0; y < width; y++) {
                if (grid[x][y] != 0) {
                    int tempLen = getArea(x, y, grid, high, width);
                    ans = Math.max(ans, tempLen);
                }
            }
        }
        return ans;
    }

    private int getArea(int x, int y, int[][] grid, int high, int width) {
        if (x > -1 && x < high && y > -1 && y < width && grid[x][y] != 0) {
            grid[x][y] = 0;
            return (1 + getArea(x, y + 1, grid, high, width) + getArea(x + 1, y, grid, high, width)
                    + getArea(x, y - 1, grid, high, width) + getArea(x - 1, y, grid, high, width));
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] data = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(data));
    }

}
