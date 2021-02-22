package p1356;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/23 1:00
 */
public class Solution {

    public int[] sortByBits(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                int b1 = bits(data[j]);
                int b2 = bits(data[j + 1]);
                if (b1 > b2 || (b1 == b2 && data[j] > data[j + 1])) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    private static int bits(int a) {
        int count = 0;
        while (a > 0) {
            if (a % 2 == 1) {
                count++;
            }
            a /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortByBits(data)));
    }

}
