package p41;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Glory
 * @date 2020/6/27 9:24
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }

        for (int i = 1; i <= map.size() + 1; i++) {
            if (map.get(i) == null) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(nums));
    }
}
