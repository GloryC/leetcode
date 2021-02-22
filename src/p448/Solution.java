package p448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Glory
 * @date 2019/10/23 8:43
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] ints = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = 1;
        }
        List<Integer> result = new ArrayList<>(ints.length + 1);
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] != 1) {
                result.add(i);
            }
        }
        return result;
    }

}
