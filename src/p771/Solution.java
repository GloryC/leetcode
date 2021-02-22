package p771;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Glory
 * @date 2019/9/20 10:12
 */
public class Solution {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>(1);
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }
}


