package p845;

/**
 * @author Glory
 * @date 2020/10/25 20:45
 */
public class Solution {
    public int longestMountain(int[] A) {
        int maxLength = 0;
        int i = 1;

        while (i < A.length) {
            int increasing = 0, decreasing = 0;

            while (i < A.length && A[i - 1] < A[i]) {
                i++;
                increasing++;
            }

            while (i < A.length && A[i - 1] > A[i]) {
                i++;
                decreasing++;
            }

            if (increasing > 0 && decreasing > 0) {
                maxLength = Math.max(maxLength, increasing + decreasing + 1);
            }

            while (i < A.length && A[i - 1] == A[i]) {
                i++;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        Solution solution = new Solution();
        System.out.println(solution.longestMountain(A));
    }
}
