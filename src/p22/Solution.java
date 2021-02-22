package p22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Glory
 * @date 2019/10/29 9:00
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList("()");
        }

        List<String> res = new ArrayList<>();
        this.generate(1, n, res, "(");
        return res;
    }

    private void generate(int left, int max, List<String> res, String cur) {
        if (cur.length() >= max * 2) {
            res.add(cur);
            return;
        }
        if (left < max) {
            this.generate(left + 1, max, res, cur + "(");
        }
        if (cur.length() < left * 2) {
            this.generate(left, max, res, cur + ")");
        }
    }


}
