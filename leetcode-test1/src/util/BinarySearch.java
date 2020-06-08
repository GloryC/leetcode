package util;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/28 14:28
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int data) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == data) {
                return mid;
            } else if (array[mid] < data) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 5, 5, 5, 7, 5};
        QuickSort.quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        int res = binarySearch(data, 5);
        System.out.println(res);
    }

}
