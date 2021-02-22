package p459;

/**
 * @author zhanggc
 * @date 2020/8/24 8:34
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
