package p151;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Glory
 * @date 2020/4/10 13:53
 */
public class Solution2 {
    public String reverseWords(String s) {
        String[] data = s.trim().split(" +");
        Collections.reverse(Arrays.asList(data));
        return String.join(" ", data);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.reverseWords("a good   example"));
    }
}
