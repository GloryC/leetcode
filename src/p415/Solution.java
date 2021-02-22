package p415;

/**
 * @author zhanggc
 * @date 2020/8/3 8:47
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            stringBuilder.append(carry % 10);
            carry /= 10;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("123", "456"));
    }
}
