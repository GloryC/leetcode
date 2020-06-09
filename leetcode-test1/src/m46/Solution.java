package m46;

/**
 * @author Glory
 * @date 2020/6/9 8:45
 */
public class Solution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        char[] charArray = str.toCharArray();
        int len = charArray.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int sum = charArray[0] - '0';

        for (int i = 1; i < len; i ++) {
            sum = sum * 10 + (charArray[i] - '0');
            if (sum >= 0 && sum < 26 && charArray[i-1] != '0') {
                dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
            } else {
                dp[i] = dp[i - 1];
            }
            sum = charArray[i] - '0';
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }

}
