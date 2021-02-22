package p961;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Glory
 * @date 2019/9/24 9:10
 */
public class Solution {

    public int repeatedNTimes2(int[] A) {
        Map<Integer, Integer> count = new HashMap<>(10);
        for (int x : A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k : count.keySet()) {
            if (count.get(k) > 1) {
                return k;
            }
        }
        throw null;
    }


    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }
}
