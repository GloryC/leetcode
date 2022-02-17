package com.glory.leetcode.p48;

import java.util.Arrays;

/**
 * @author zhanggc
 * @date 2022-02-17 21:02:15
 */
public class RotateImage {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(data);
        System.out.println(Arrays.deepToString(data));
    }

    static class Solution {

        /**
         * 我们可以先将 n x n 矩阵 matrix 按照左上到右下的对角线进行镜像对称：
         * 然后再对矩阵的每一行进行反转：
         * 发现结果就是 matrix 顺时针旋转 90 度的结果：
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 先沿对角线镜像对称二维矩阵
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            // 反转二维矩阵的每一行
            for (int[] row : matrix) {
                reverse(row);
            }
        }

        private void reverse(int[] arr) {
            int i = 0, j = arr.length - 1;
            while (j > i) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

}
