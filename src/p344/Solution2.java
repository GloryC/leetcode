package p344;

/**
 * @author Glory
 * @date 2019/12/11 9:56
 */
public class Solution2 {

    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            s[i] ^= s[n - i - 1];
            s[n - i - 1] ^= s[i];
            s[i] ^= s[n - i - 1];
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        Solution2 solution2 = new Solution2();
        solution2.reverseString(s);
        System.out.println(s);
    }

}
