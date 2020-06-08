package p88;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/5/1 22:17
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int c = 0, c1 = 0, c2 = 0;

        while (c1 < m && c2 < n) {
            if (nums1[c1] < nums2[c2]) {
                res[c++] = nums1[c1++];
            } else {
                res[c++] = nums2[c2++];
            }
        }

        while (c1 < m) {
            res[c++] = nums1[c1++];
        }

        while (c2 < n) {
            res[c++] = nums2[c2++];
        }

        System.arraycopy(res, 0, nums1, 0, res.length);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }
}
