package p20;

/**
 * @author Glory
 * @date 2019/10/28 8:54
 */
public class Solution2 {

    /**
     * 思路：循环替换字符串，每次替换一对括号，最后如果剩下空字符串则匹配成功
     */
    public boolean isValid(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (length != s.length());
        return s.length() == 0;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isValid("([)]"));
    }
}
