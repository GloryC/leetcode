package p1370;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/23 0:26
 */
public class Solution {

    public String sortString(String s) {
        char[] data = s.toCharArray();
        int[] count = new int[30];
        int len = data.length;
        for (int i = 0; i < len; i++) {
            count[data[i] - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (len > 0) {
            for (int i = 0; i < 30; i++) {
                if (count[i] > 0) {
                    count[i]--;
                    len--;
                    stringBuilder.append((char) (i + 'a'));
                }
            }
            for (int i = 29; i >= 0; i--) {
                if (count[i] > 0) {
                    count[i]--;
                    len--;
                    stringBuilder.append((char) (i + 'a'));
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortString("leetcode"));
    }

}
