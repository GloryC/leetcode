package p852;

/**
 * @author Glory
 * @date 2019/9/11 20:56
 */
public class Solution {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) {
                return --i;
            }
        }
        return -1;
    }

}
