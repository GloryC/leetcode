package p9;

/**
 * @author Glory
 * @date 2020/6/10 12:46
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long y = 0;
        long q = x;
        while (x != 0) {
            int t = x % 10;
            y = y * 10 + t;
            x /= 10;
        }
        return y == q;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(101));
    }
}
