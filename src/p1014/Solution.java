package p1014;

/**
 * @author Glory
 * @date 2020/6/17 9:34
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int left = A[0], res = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, left + A[i] - i);
            left = Math.max(left, A[i] + i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {8, 1, 5, 2, 6};
        Solution solution = new Solution();
        System.out.println(solution.maxScoreSightseeingPair(A));
    }
}
