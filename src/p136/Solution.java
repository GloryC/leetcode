package p136;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Glory
 * @date 2019/10/22 10:47
 */
public class Solution {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }

}
