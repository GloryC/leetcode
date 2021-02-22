package p912;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/31 14:00
 */
public class Solution3 {

    public int[] sortArray(int[] nums) {
        bubbleSort(nums);
        return nums;
    }

    private void bubbleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;  // 已经排序完成
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 1, 1, 2, 0, 0};
        Solution3 solution = new Solution3();
        System.out.println(Arrays.toString(solution.sortArray(data)));
    }

}
