package p349;

import java.util.*;

/**
 * @author Glory
 * @date 2020/3/5 18:26
 */
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>(nums1.length);
        HashSet<Integer> set2 = new HashSet<>(nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<Integer> data = new LinkedList<>();
        for (int e : set1) {
            if (set2.contains(e)){
                data.add(e);
            }
        }

        int[] result = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        Solution2 solution = new Solution2();
        int[] intersection = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

}
