package p242;

import java.util.HashMap;

/**
 * @author Glory
 * @date 2020/6/11 15:45
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            Integer i = map.get(c);
            map.put(c, i == null ? 1 : ++i);
        }
        char[] ct = t.toCharArray();
        for (char c : ct) {
            Integer i = map.get(c);
            if (i == null){
                return false;
            } else if (i > 1) {
                map.put(c, --i);
            } else {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("a", "b"));
    }
}
