package p922;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/5 19:19
 */
public class Solution {

    private static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public int[] sortArrayByParityII(int[] a) {
        int[] res = new int[a.length];
        int even = 0;
        int odd = 1;
        for (int num : a) {
            if (isOdd(num)) {
                res[odd] = num;
                odd += 2;
            } else {
                res[even] = num;
                even += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {4, 2, 5, 7};
        int[] ints = solution.sortArrayByParityII(data);
        System.out.println(Arrays.toString(ints));
    }

}
