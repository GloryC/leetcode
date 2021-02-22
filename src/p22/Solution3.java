package p22;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Glory
 * @date 2019/10/29 9:00
 */
public class Solution3 {

    private LinkedList<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return res;
    }

    private void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            res.add(s);
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }

        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.generateParenthesis(3));
    }
}
