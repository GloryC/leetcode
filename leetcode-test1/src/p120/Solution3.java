package p120;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/3/10 13:06
 */
public class Solution3 {

    /**
     * 自底向上的递推
     * dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
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
        Solution3 solution = new Solution3();
        System.out.println(solution.minimumTotal(data));
    }

}
