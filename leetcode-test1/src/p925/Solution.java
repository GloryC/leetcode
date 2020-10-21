package p925;

/**
 * @author zhanggc
 * @date 2020/10/21 17:20
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName("alex", "aaleex"));
    }
}
