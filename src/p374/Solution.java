package p374;

/**
 * @author zhanggc
 * @date 2021/3/3 14:59
 */
public class Solution {

    /**
     * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
     * <p>
     * -1：我选出的数字比你猜的数字小 pick < num
     * 1：我选出的数字比你猜的数字大 pick > num
     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     */
    public int guessNumber(int n) {
        int left = 1, right = n, mid, res;
        while (left <= right) {
            mid = left + (right - left) / 2;
            res = guess(mid);
            if (res == 1) {
                left = mid + 1;
            } else if (res == -1) {
                right = mid - 1;
            } else if (res == 0) {
                return mid;
            }
        }

        return -1;
    }

    private int guess(int mid) {
        return -1;
    }

}
