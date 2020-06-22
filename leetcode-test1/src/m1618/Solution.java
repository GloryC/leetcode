package m1618;

/**
 * @author Glory
 * @date 2020/6/22 8:45
 */
public class Solution {
    public boolean patternMatching(String pattern, String value) {
        if (value.length() == 0) {
            for (int i = 0; i < pattern.length(); i++) {
                if (i == 0)
                    continue;
                if (pattern.charAt(i) != pattern.charAt(i - 1))
                    return false;
            }
            return true;
        }

        if (pattern.length() == 0) {
            return false;
        }

        //记录a的数量和b的数量，以及第一个a或b之前有多少个b或a，这样后面可以直接推出第一个a或b的坐标
        //比如第一个b的起始坐标为prea*aLen，那他的字符串为value.substring(prea*aLen, prea*aLen+bLen);
        int aCount = 0, bcount = 0, preb = 0, aPos = -1, prea = 0, bPos = -1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                aCount++;
                if (aPos == -1) {
                    preb = bcount;
                    aPos = i;
                }
            } else {
                bcount++;
                if (bPos == -1) {
                    prea = aCount;
                    bPos = i;
                }
            }
        }
        if (aCount == 1 || bcount == 1)
            return true;

        if (aCount == 0 && (value.length() % bcount != 0) || (bcount == 0 && (value.length() % aCount != 0)))
            return false;

        //开始整活
        int aLength = 0;
        if (aCount != 0) //如果aCount==0，那么b只有一种可能，这样写防止/zero报错
            aLength = value.length() / aCount;
        for (int aLen = 0; aLen <= aLength; aLen++) {
            if (bcount != 0 && (value.length() - aCount * aLen) % bcount != 0)
                continue;
            int bLen = 0;   //防止报错
            if (bcount != 0)
                bLen = (value.length() - aCount * aLen) / bcount;

            String aAlp = value.substring(preb * bLen, preb * bLen + aLen);
            String bAlp = value.substring(prea * aLen, prea * aLen + bLen);
            int pos = 0, cur = 0;
            while (pos < value.length() && cur < pattern.length()) {
                if (aLen != 0 && pattern.charAt(cur) == 'a') {
                    if (pos + aLen <= value.length() && value.substring(pos, pos + aLen).equals(aAlp))
                        pos += aLen;
                    else
                        break;
                } else if (bLen != 0 && pattern.charAt(cur) == 'b') {
                    if (pos + bLen <= value.length() && value.substring(pos, pos + bLen).equals(bAlp))
                        pos += bLen;
                    else
                        break;
                } else
                    pos++;
                cur++;
            }
            //pos能走一个流程，说明匹配成功
            if (pos >= value.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.patternMatching("abba", "dogcatcatfish"));
    }

}
