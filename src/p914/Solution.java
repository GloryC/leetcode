package p914;

/**
 * @author Glory
 * @date 2020/3/27 13:25
 */
public class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) return false;
        int[] count = new int[100005];
        for (int num : deck) {
            count[num]++;
        }
        int x = 0;
        for (int cnt : count) {
            if (cnt > 0) {
                x = gcd(x, cnt);
                if (x == 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }

    // 辗转相除法
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int gcd2(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] data = {1, 1, 2, 2, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.hasGroupsSizeX(data));
    }

}
