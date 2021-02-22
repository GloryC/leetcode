package m56v1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Glory
 * @date 2020/4/28 15:03
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int[] counts = new int[10005];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < 10005; i++) {
            if (counts[i] == 1) {
                res.add(i);
            }
        }

        int[] data = new int[res.size()];
        int i = 0;
        for (int num : res) {
            data[i++] = num;
        }
        return data;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 10, 4, 1, 4, 3, 3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.singleNumbers(nums)));
    }
}
