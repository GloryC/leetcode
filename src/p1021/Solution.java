package p1021;

/**
 * @author Glory
 * @date 2019/9/11 21:00
 */
public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] ch = S.toCharArray();
        int pRight = 0;
        int pLeft = 0;
        for (int i = 0; i < ch.length; i++) {
            if ('(' == ch[i]) {
                pLeft++;
            }
            if (')' == ch[i]) {
                pRight++;
            }
            if (pLeft == pRight) {
                stringBuilder.append(S.substring(i - pLeft * 2 + 2, i));
                pLeft = pRight = 0;
            }
        }
        return stringBuilder.toString();
    }
}
