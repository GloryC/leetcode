package p344;

/**
 * @author Glory
 * @date 2019/12/11 9:56
 */
public class Solution {

    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char c = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = c;
        }
    }

}
