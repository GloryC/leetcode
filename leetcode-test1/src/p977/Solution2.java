package p977;

/**
 * @author zhanggc
 * @date 2020/10/16 9:10
 */
public class Solution2 {

    /**
     * 我们可以使用两个指针分别指向位置 00 和 n-1n−1，
     * 每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。
     */
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}
