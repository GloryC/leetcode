package p7;

/**
 * @author Glory
 * @date 2020/3/30 15:11
 */
public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        StringBuilder str = new StringBuilder();
        if (x < 0) {
            str.append("-");
            x = -x;
        }
        while (x != 0) {
            str.append(x % 10);
            x /= 10;
        }
        try {
            return Integer.parseInt(str.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(2147483647));
    }
}
