package p766;

/**
 * @author zhanggc
 * @date 2021/2/22 16:20
 */
public class Solution {

    /**
     * 根据定义，当且仅当矩阵中每个元素都与其左上角相邻的元素（如果存在）相等时，该矩阵为托普利茨矩阵。
     * 因此，我们遍历该矩阵，将每一个元素和它左上角的元素相比对即可。。
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
