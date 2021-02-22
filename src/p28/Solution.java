package p28;

/**
 * @author Glory
 * @date 2020/6/19 10:32
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle, 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aaaaa", "baa"));
    }
}
