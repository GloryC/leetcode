package p151;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/4/10 13:53
 */
public class Solution {
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] data = trim.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(data[data.length - 1]);
        for (int i = data.length - 2; i >= 0; i--) {
            System.out.println(stringBuilder.toString());
            stringBuilder = new StringBuilder(stringBuilder.toString().trim());
            stringBuilder.append(" ").append(data[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }
}
