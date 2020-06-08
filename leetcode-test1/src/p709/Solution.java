package p709;

/**
 * @author Glory
 * @date 2019/10/30 8:49
 */
public class Solution {

    public String toLowerCase(String str) {
        char[] st = new char[str.length()];
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                c = (char) (c + 32);
            }
            st[i] = c;
        }
        return new String(st);
    }

}
