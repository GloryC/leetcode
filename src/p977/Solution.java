package p977;

import java.util.Arrays;

/**
 * @author zhanggc
 * @date 2020/10/16 9:10
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
