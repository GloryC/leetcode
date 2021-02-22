package p974;

/**
 * @author Glory
 * @date 2020/5/27 13:24
 */
public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        Solution solution = new Solution();
        System.out.println(solution.subarraysDivByK(nums, 5));
    }

}