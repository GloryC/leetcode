package p392;

/**
 * @author Glory
 * @date 2020/3/10 12:46
 */
public class Solution {
    /**
     * 双指针
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1; // 保证第一个元素从0开始
        for (char c: s.toCharArray()) {
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("adc","abcde"));
    }

}
