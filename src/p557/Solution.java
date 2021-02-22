package p557;

/**
 * @author Glory
 * @date 2020/8/30 12:34
 */
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                res.append(" ");
            }
            res.append(new StringBuilder(words[i]).reverse().toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
