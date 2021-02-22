package p463;

/**
 * @author Glory
 * @date 2020/3/25 0:11
 */
public class Solution {

    public int islandPerimeter(int[][] grid) {
        int num = 0;
        // 直接遍历数组，只要前面有相邻的方格，就-2
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    num += 4;
                    // 上下相邻
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        num -= 2;
                    }
                    // 左右相邻
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                        num -= 2;
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] data = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        Solution solution = new Solution();
        System.out.println(solution.islandPerimeter(data));

    }

}
