package p263;

/**
 * @author Glory
 * @date 2020/3/10 21:54
 */
public class Solution {

    public boolean isUgly(int num) {
        if (num < 1) return false;
        if (num == 1) return true;
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUgly(14));
    }

}
