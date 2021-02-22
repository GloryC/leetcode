package p139;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/6/26 10:13
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String str : wordDict) {
                int length = str.length();
                if (length <= i && dp[i - length] && str.equals(s.substring(i - length, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        List<String> wordDict = new LinkedList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("applepenapple", wordDict));
    }
}
