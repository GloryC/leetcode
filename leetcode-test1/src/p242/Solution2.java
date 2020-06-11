package p242;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/6/11 15:45
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isAnagram("a", "b"));
    }
}
