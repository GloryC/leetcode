package m62;

import java.util.ArrayList;

/**
 * @author Glory
 * @date 2020/3/30 14:49
 */
public class Solution2 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.lastRemaining(5, 3));
    }

}
