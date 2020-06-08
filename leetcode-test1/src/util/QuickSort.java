package util;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/28 14:28
 */
public class QuickSort {

    public static void quickSort(int[] data, int left, int right) {
        int base = data[left];
        int ll = left, rr = right;
        while (ll < rr) {
            while (ll < rr && data[rr] >= base) {
                rr--;
            }
            if (ll < rr) {
                int temp = data[ll];
                data[ll] = data[rr];
                data[rr] = temp;
                ll++;
            }

            while (ll < rr && data[ll] <= base) {
                ll++;
            }
            if (ll < rr) {
                int temp = data[ll];
                data[ll] = data[rr];
                data[rr] = temp;
                rr--;
            }
        }

        if (left < ll) {
            quickSort(data, left, ll - 1);
        }
        if (rr < right) {
            quickSort(data, rr + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 5, 6, 7, 3};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

}
