package p69;

/**
 * @author Glory
 * @date 2020/5/9 16:20
 */
public class Solution {
    public int mySqrt(int x) {
        long res = 0, i;
        for (i = 1; res < x; i++) {
            res = i * i;
        }
        i--;
        return (int) (i * i == x ? i : i - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147483647));
    }

}
