package p7;

/**
 * @author Glory
 * @date 2020/3/30 15:11
 */
public class Solution2 {
    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.reverse(2147483647));
    }
}
