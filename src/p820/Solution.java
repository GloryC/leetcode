package p820;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/28 14:05
 */
public class Solution {

    public int minimumLengthEncoding(String[] words) {
        if (words.length < 1) return 0;
        if (words.length == 1) return words[0].length() + 1;
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        String sb = "";
        for (String word : words) {
            if (!sb.contains(word + "#")) {
                sb = sb.concat(word + "#");
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        String[] data = {"time", "me", "bell"};
//        String[] data = {"t"};
//        String[] data = {"me", "time"};
        Solution solution = new Solution();
        System.out.println(solution.minimumLengthEncoding(data));
    }

}
