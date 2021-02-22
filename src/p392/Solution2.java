package p392;

/**
 * @author Glory
 * @date 2020/3/10 12:46
 */
public class Solution2 {

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isSubsequence("adc", "abcde"));
    }

}
