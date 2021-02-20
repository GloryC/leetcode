package p697;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度
 *
 * @author zhanggc
 * @date 2021/2/20 13:51
 */
public class Solution {

    /**
     * 在实际代码中，我们使用哈希表实现该功能，每一个数映射到一个长度为 33 的数组，数组中的三个元素分别代表这个数出现的次数、
     * 这个数在原数组中第一次出现的位置和这个数在原数组中最后一次出现的位置。当我们记录完所有信息后，我们需要遍历该哈希表，
     * 找到元素出现次数最多，且前后位置差最小的数。
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(nums));
    }

}
