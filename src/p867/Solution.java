package p867;

/**
 * @author zhanggc
 * @date 2021/2/25 10:48
 */
public class Solution {

    /**
     * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

}
