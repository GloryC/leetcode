package m64;

/**
 * @author Glory
 * @date 2020/6/2 8:37
 */
public class Solution {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNums(3));
    }
}
