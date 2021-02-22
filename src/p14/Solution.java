package p14;

import java.nio.channels.UnresolvedAddressException;
import java.util.HashMap;

/**
 * @author Glory
 * @date 2020/6/15 8:28
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        HashMap<Integer, Character> map = new HashMap<>();
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        char[] char0 = strs[0].toCharArray();
        for (int i = 0; i < char0.length; i++) {
            map.put(i, char0[i]);
        }
        int count1 = 0;
        for (int i = 1; i < strs.length; i++) {
            char[] chari = strs[i].toCharArray();
            int count2 = 0;
            for (int j = 0; j < chari.length; j++) {
                if (map.containsKey(j) && map.get(j) == chari[j]) {
                    count2++;
                } else {
                    break;
                }
            }
            count1 = i == 1 ? count2 : Math.min(count1, count2);
        }
        return strs[0].substring(0, count1);
    }

    public static void main(String[] args) {
        String[] strs = {"c", "acc", "ccc"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
