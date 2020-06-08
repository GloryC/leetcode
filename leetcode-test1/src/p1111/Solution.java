package p1111;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/4/1 14:11
 */
public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        char[] data = seq.toCharArray();
        int[] ans = new int[data.length];
        int index = 0;
        for (char c : data) {
            ans[index++] = c == '(' ? index & 1 : ((index + 1) & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxDepthAfterSplit("()(())()")));
    }

}
