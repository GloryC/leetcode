package p844;

/**
 * @author zhanggc
 * @date 2020/10/19 9:07
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String str) {
        StringBuilder res = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c != '#') {
                res.append(c);
            } else {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab##", "ad##"));
    }
}
