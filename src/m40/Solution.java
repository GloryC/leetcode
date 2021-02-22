package m40;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/20 0:24
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        int[] data = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            data[arr[i]]++;
        }
        int[] result = new int[k];
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                for (int l = 0; l < data[i]; l++) {
                    result[j++] = i;
                    if (j >= k) return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4, 8};
        int[] result = solution.getLeastNumbers(data, 8);
        System.out.println(Arrays.toString(result));
    }

}
