package p329;

/**
 * @author Glory
 * @date 2020/7/26 17:19
 */
public class Solution {
    private int longest; // 在遍历过程中记录每个点递增能到达的最长路径的最大值，可以省去最后对max数组遍历取最大；
    private final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 方向数组，路径问题必备

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] max = new int[m * n];// 用二维数组也可以，没太大区别，占用空间都是m * n
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max[i * n + j] == 0) { // 对于已经访问并记录了最大递增路径的节点，直接跳过；
                    _longestIncreasingPath(matrix, max, i, j, m, n);
                }
            }
        }
        return longest;
    }

    // 找到（x, y）节点能访问到的最大路径，期间记录到max中；
    private int _longestIncreasingPath(int[][] matrix, int[] max, int x, int y, int m, int n) {
        //terminator 遇到有记录过的最大路径 直接返回路径
        int index = x * n + y;
        if (max[index] != 0) return max[index];
        max[index] = 1; // 未记录过的位置，能访问到的路径至少为1
        for (int[] dir : directions) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            // 关键：只找递增的路径，进行下探（因为只找的递增，所以保证了不会往回跑）
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && matrix[x][y] < matrix[nextX][nextY]) {
                max[index] = Math.max(max[index], _longestIncreasingPath(matrix, max, nextX, nextY, m, n) + 1);
            }
        }
        longest = Math.max(longest, max[index]);
        return max[index];
    }

}