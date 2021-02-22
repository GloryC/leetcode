package p560;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Glory
 * @date 2020/5/15 8:48
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                res += map.get(sum - k);   // 获取sum-k有多少种可能
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(nums, 0));
    }

}
