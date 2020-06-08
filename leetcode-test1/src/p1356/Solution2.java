package p1356;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/23 1:00
 */
public class Solution2 {

    public int[] sortByBits(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

        int[] res = new int[arr.length];
        int[] countArr = new int[14];
        int[] bitCountArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int count = 0;
            while (temp > 0) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp >>= 1;
            }
            bitCountArr[i] = count;
            countArr[count]++;
        }

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            res[countArr[bitCountArr[i]] - 1] = arr[i];
            countArr[bitCountArr[i]]--;
        }

        return res;
    }

    private static void quickSort(int[] data, int left, int right) {
        int base = data[left];
        int ll = left;
        int rr = right;
        while (ll < rr) {
            while (ll < rr && data[rr] >= base) {
                rr--;
            }
            if (ll < rr) {
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                ll++;
            }
            while (ll < rr && data[ll] <= base) {
                ll++;
            }
            if (ll < rr) {
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                rr--;
            }
        }

        if (left < ll) {
            quickSort(data, left, ll - 1);
        }
        if (ll < right) {
            quickSort(data, ll + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] data = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.sortByBits(data)));
    }

}
