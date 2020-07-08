package m1611;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/7/8 8:34
 */
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{shorter * k};
        int[] result = new int[k + 1];
        int start = shorter * k;
        for (int i = 0; i <= k; i++) {
            result[i] = start + (longer - shorter) * i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.divingBoard(3, 4, 3)));
    }
}
