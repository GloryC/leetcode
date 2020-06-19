package p125;

/**
 * @author Glory
 * @date 2020/6/19 8:32
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if ("".equals(s)) return true;
        String s1 = s.toLowerCase();
        char[] chars = s1.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                stringBuilder.append(c);
            }
        }
        String s2 = stringBuilder.toString();
        String s3 = stringBuilder.reverse().toString();
        return s2.equals(s3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
