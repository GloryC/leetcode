package p179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhanggc
 * @date 2021/4/12 14:13
 */
public class Solution {

    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * <p>
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     */
    public String largestNumber(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        String result = sb.toString();

        //特殊情况 若干个零
        if (result.charAt(0) == '0') {
            result = "0";
        }
        return result;
    }

}
