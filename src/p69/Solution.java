package p69;

/**
 * @author Glory
 * @date 2020/5/9 16:20
 */
public class Solution {

    /**
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 采用二分查找法实现
     */
    public int mySqrt(int x) {
        int min = 1, max = x, mid = 0;
        while (min <= max) {
            mid = min + (max - min) / 2;
            long value = (long) mid * mid;
            if (value < x) {
                min = mid + 1;
            } else if (value > x) {
                max = mid - 1;
            } else if (value == x) {
                return mid;
            }
        }

        return (long) mid * mid <= x ? mid : mid - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(8));
    }

}
