package p322;

/**
 * @author Glory
 * @date 2020/3/8 22:21
 */
public class Solution {

    public int coinChange2(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange2(coins, rem - coin, count);
            if (res >= 0 && res < min) min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange2(coins, amount, new int[amount]);
    }

}
