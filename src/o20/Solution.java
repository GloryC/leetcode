package o20;

/**
 * @author zhanggc
 * @date 2020/9/2 8:53
 */
public class Solution {
    public boolean isNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return !s.contains("f") && !s.contains("F") && !s.contains("d") && !s.contains("D");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("+100"));
    }
}
