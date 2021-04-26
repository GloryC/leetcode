package p1351;

/**
 * @author Glory
 * @date 2020/4/12 0:39
 */
public class Solution {
    /**
     * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
     * 请你统计并返回 grid 中 负数 的数目。
     */
    public int countNegatives(int[][] grid) {
        int sum = 0;
        for (int[] ints : grid) {
            // 利用二分查找,找到最大的负数的下标!
            int left = 0;
            int right = ints.length - 1;
            int temp = ints.length;
            sum = sum + right + 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ints[mid] >= 0) {
                    left = mid + 1;
                } else {
                    temp = mid;
                    right = mid - 1;
                }
            }
            sum = sum - temp;
        }
        return sum;
    }

}
