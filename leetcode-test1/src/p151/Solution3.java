package p151;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Glory
 * @date 2020/4/10 13:53
 */
public class Solution3 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = arr.length - 1; i >= 0; i--) {
            if ("".equals(arr[i])) {
                continue;
            }
            sb.append(arr[i]).append(" ");
        }
        String res = sb.toString();
        if ("".equals(res)) {
            return res;
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.reverseWords("a good   example"));
    }
}
