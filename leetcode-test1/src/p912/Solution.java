package p912;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/31 14:00
 */
public class Solution {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] data, int left, int right) {
        int base = data[left];
        int ll = left, rr = right;
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
        if (rr < right) {
            quickSort(data, rr + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 1, 1, 2, 0, 0};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArray(data)));
    }

}
