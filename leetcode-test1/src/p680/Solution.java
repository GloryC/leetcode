package p680;

/**
 * @author Glory
 * @date 2020/5/19 8:41
 */
public class Solution {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int index = isPalindrome(chars);
        if (index == -1) {
            return true;
        } else {
            String s1 = s.substring(0, index);
            String s2 = s.substring(index + 1);
            String s3 = s1.concat(s2);
            if (isPalindrome(s3.toCharArray()) == -1) {
                return true;
            } else {
                int index2 = chars.length - index - 1;
                String s4 = s.substring(0, index2);
                String s5 = s.substring(index2 + 1);
                String s6 = s4.concat(s5);
                return isPalindrome(s6.toCharArray()) == -1;
            }
        }
    }

    public int isPalindrome(char[] chars) {
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            if (chars[i] != chars[j]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("abca"));
    }

}
