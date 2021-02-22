package p202;

/**
 * @author Glory
 * @date 2020/4/30 11:50
 */
public class Solution {
    public boolean isHappy(int n) {
        int res = add(n);
        for (int i = 0; i < 100; i++) {
            if (res == 1) return true;
            res = add(res);
        }
        return false;
    }

    private int add(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(101));
    }

}
