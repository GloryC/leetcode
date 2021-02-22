package p1342;

/**
 * @author Glory
 * @date 2020/3/26 14:22
 */
public class Solution {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num -= 1;
                count++;
            } else {
                num >>= 1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(8));
    }

}
