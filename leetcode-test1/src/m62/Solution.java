package m62;

import java.util.ArrayList;

/**
 * @author Glory
 * @date 2020/3/30 14:49
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> data = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            data.add(i);
        }

        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            data.remove(index); // remove by index
            n--;
        }
        return data.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(10, 17));
    }

}
