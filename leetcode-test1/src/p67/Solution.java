package p67;

/**
 * @author Glory
 * @date 2020/6/23 8:41
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        char[] ca = sa.reverse().toString().toCharArray();
        char[] cb = sb.reverse().toString().toCharArray();
        int len = Math.max(ca.length, cb.length);
        StringBuilder res = new StringBuilder();
        int up = 0;
        for (int i = 0; i < len; i++) {
            int ia, ib;
            if (i >= ca.length) ia = 0;
            else ia = ca[i] - '0';
            if (i >= cb.length) ib = 0;
            else ib = cb[i] - '0';

            int tmp = ia + ib + up;
            res.append(tmp % 2);
            if (tmp > 1) up = 1;
            else up = 0;
        }

        if (up > 0) {
            res.append(up);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}
