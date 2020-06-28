package p1387;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/28 16:58
 */
public class Solution {
    /**
     * 我们计算出每个数的权重，按照顺序存放进行数组 weight 中
     * 比如 lo = 7, hi = 11
     * 则 weight = {16, 3, 19, 6, 14}
     * <p>
     * 因为我们需要进行排序，排序的话会导致顺序混乱，那么我们就需要记录每个数对应的权重位置
     * 那么我们开二维数组， int[][] weight = new int[len][2];
     * weight[i][0] 记录权重
     * weight[i][1] 记录对应的数
     * <p>
     * 那么我们就可以进行排序，当权重一样，按照元素数值升序排序，当权重不一样，按照权重排序
     */
    public int getKth(int lo, int hi, int k) {
        int len = hi - lo + 1;
        int[][] weight = new int[len][2];
        for (int i = 0; i < len; i++, lo++) {
            weight[i][0] = helper(lo);
            weight[i][1] = lo;
        }
        Arrays.sort(weight, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return weight[k - 1][1];
    }

    /**
     * 如果 x 是偶数，那么 x = x / 2
     * 如果 x 是奇数，那么 x = 3 * x + 1
     */
    private int helper(int num) {
        int step = 0;
        while (num != 1) {
            if ((num & 1) == 0) {  // 偶数
                num >>= 1;
            } else {
                num = num * 3 + 1;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getKth(12, 15, 2));
    }
}
