package p1071;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Glory
 * @date 2020/3/12 1:12
 */
public class Solution {

    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ABCABCABC", "ABC"));
//        String abc = "ABCABCABC";
//        System.out.println(abc.substring(3));
//        System.out.println(abc.indexOf("ABC", 3));
        Stack<Integer> stack = new Stack<>();

    }

}
