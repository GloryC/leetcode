package o1001;

/**
 * @author zhanggc
 * @date 2021/2/25 14:18
 */
public class Solution {

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 2 || n == 1) return 1;
        int pre = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = (pre + cur) % 1000000007;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(10));
    }

}
