package p1370;

/**
 * @author Glory
 * @date 2020/3/23 0:26
 */
public class Solution2 {
    public String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() != s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] == 0) continue;
                sb.append((char) ('a' + i));
                count[i]--;
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i] == 0) continue;
                sb.append((char) ('a' + i));
                count[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.sortString("leetcode"));
    }

}
