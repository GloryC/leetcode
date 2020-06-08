package p338;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/8 22:54
 */
public class Solution {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int t = i;
            int count = 0;
            while (t > 0) {
                if ((t & 1) == 1) {
                    count++;
                }
                t >>= 1;
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(5)));
    }

}
