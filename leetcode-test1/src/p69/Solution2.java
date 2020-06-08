package p69;

/**
 * @author Glory
 * @date 2020/5/9 16:20
 */
public class Solution2 {
    public int mySqrt(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.mySqrt(2147483647));
    }

}
