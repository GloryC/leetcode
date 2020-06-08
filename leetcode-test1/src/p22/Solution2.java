package p22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Glory
 * @date 2019/10/29 9:00
 */
public class Solution2 {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        if (left > 0) dfs(left - 1, right, curStr + "(");
        if (right > left) dfs(left, right - 1, curStr + ")");
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.generateParenthesis(3).toString());
    }

}
