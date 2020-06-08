package p581;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2019/10/28 9:22
 */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int start = sortedNums.length, end = 0;
        for (int i = 0; i < sortedNums.length; i++) {
            if (sortedNums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start > 0 ? end - start + 1 : 0);
    }

}
