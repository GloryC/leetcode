package p88;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/5/1 22:17
 */
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        Solution2 solution = new Solution2();
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }
}
