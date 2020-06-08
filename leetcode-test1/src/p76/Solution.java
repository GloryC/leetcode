package p76;

/**
 * @author Glory
 * @date 2020/5/23 12:14
 */
public class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部还差多少 T 中的字符，对应字符频数超过不重复计算
        int distance = tLen;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        // [left..right)
        while (right < sLen) {
            char charRight = charArrayS[right];
            if (tFreq[charRight] > 0) {
                distance--;
            }
            tFreq[charRight]--;
            right++;

            // System.out.println(distance + " " + s.substring(left, right));
            while (distance == 0) {
                // System.out.println("左边界收缩 " + distance + " " + s.substring(left, right));
                // System.out.println(tFreq['A'] + "," + tFreq['B'] + "," + tFreq['C']);

                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                char charLeft = charArrayS[left];
                tFreq[charLeft]++;
                if (tFreq[charLeft] > 0) {
                    distance++;
                }
                left++;
            }
        }

        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
