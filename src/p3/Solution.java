package p3;

import java.util.HashSet;

/**
 * @author Glory
 * @date 2020/5/2 18:19
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> idx;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            idx = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (!idx.contains(chars[j])) {
                    idx.add(chars[j]);
                }else {
                    break;
                }
            }
            len = Math.max(len, idx.size());
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

}
