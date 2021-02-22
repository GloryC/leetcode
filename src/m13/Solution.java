package m13;

/**
 * @author Glory
 * @date 2020/4/8 11:43
 */
public class Solution {

    //统计到达的数量
    private int counts = 0;

    public int movingCount(int m, int n, int k) {
        //辅助数组 用来标记是否统计过
        int[][] visited = new int[m][n];
        //从 0,0位置开始统计
        helper(visited, 0, 0, m - 1, n - 1, k);
        return counts;
    }

    /**
     * 传入i,j两点 判断当前点是否符合规则 符合规则下继续对上下左右四个点递归判断
     */
    private void helper(int[][] visited, int i, int j, int m, int n, int k) {
        // System.out.println("i:"+i+"   j:"+j);
        if (i >= 0 && j >= 0 && i <= m && j <= n && visited[i][j] != 1 && (indexSum(i) + indexSum(j)) <= k) {
            // System.out.println("if  i:"+i+"   j:"+j);
            counts++;
            visited[i][j] = 1;
            helper(visited, i - 1, j, m, n, k);
            helper(visited, i + 1, j, m, n, k);
            helper(visited, i, j - 1, m, n, k);
            helper(visited, i, j + 1, m, n, k);
        }
    }

    /**
     * 根据传入的数 求出各位上的数字累加和
     */
    private int indexSum(int index) {
        int sum = index % 10;
        int tmp = index / 10;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        // System.out.println("indexSum  index:"+index+"   sum:"+sum);
        return sum;
    }

}
