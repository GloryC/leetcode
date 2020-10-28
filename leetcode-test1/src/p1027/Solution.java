package p1027;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhanggc
 * @date 2020/10/28 8:56
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        return  count.size() == new HashSet<>(count.values()).size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(arr));
    }
}
