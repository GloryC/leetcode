package p349;

import javafx.geometry.HorizontalDirection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Glory
 * @date 2020/3/5 18:26
 */
public class Solution {

    public int[] intersection2(int[] nums1, int[] nums2) {
        int length = Math.max(nums1.length, nums2.length);
        Set<Integer> result = new HashSet<>(length);
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    result.add(num1);
                    break;
                }
            }
        }
        int[] data = new int[result.size()];
        int i = 0;
        for (int a : result) {
            data[i++] = a;
        }
        return data;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int length = Math.max(nums1.length, nums2.length);
        int[] res = new int[length];
        int index = 0;
        boolean[] flags = new boolean[100000];
        for (int num : nums1) {
            flags[num] = true;
        }
        for (int num : nums2) {
            if (flags[num]) {
                res[index++] = num;
                flags[num] = false;
            }
        }
        int[] ans = new int[index];
        System.arraycopy(res, 0, ans, 0, index);
        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        Solution solution = new Solution();
        int[] intersection = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

}
