package m0106;

import java.util.Set;

/**
 * @author Glory
 * @date 2020/3/16 1:02
 */
public class Solution {

    public String compressString2(String s) {
        char[] data = s.toCharArray();
        if (data.length <= 2) return s;

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == data[i + 1]) {
                count++;
            } else {
                stringBuilder.append(data[i]);
                stringBuilder.append(count + 1);
                count = 0;
            }
        }
        if (count > 0) {
            stringBuilder.append(data[data.length - 1]);
            stringBuilder.append(count + 1);
        } else {
            stringBuilder.append(data[data.length - 1]);
            stringBuilder.append(1);
        }
        String res = stringBuilder.toString();
        if (res.length() >= data.length) {
            return s;
        } else {
            return res;
        }
    }

    public String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < cs.length; ++i) {
            ++count;
            if (i == cs.length - 1 || cs[i] != cs[i + 1]) {
                sb.append(cs[i]).append(count);
                count = 0;
            }
        }
        if (sb.length() >= s.length()) {
            return s;
        } else {
            return sb.toString();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compressString("abbccd"));
    }

}
