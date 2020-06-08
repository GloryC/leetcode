package p120;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/3/10 13:06
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int row = triangle.size();
        int column = triangle.get(row - 1).size();

        int[][] dp = new int[row][column];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;

        for (int i = 1; i < row; i++) {
            //对每一行的元素进行推导
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 最左端特殊处理
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    // 最右端特殊处理
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        // dp最后一行记录了最小路径
        for (int i = 0; i < column; i++) {
            res = Math.min(res, dp[row - 1][i]);
        }
        return res;

    }

    public static void main(String[] args) {
        List<List<Integer>> data = new LinkedList<>();
        List<Integer> data1 = Arrays.asList(2);
        List<Integer> data2 = Arrays.asList(3, 4);
        List<Integer> data3 = Arrays.asList(6, 5, 7);
        List<Integer> data4 = Arrays.asList(4, 1, 8, 3);
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(data));
    }

}
