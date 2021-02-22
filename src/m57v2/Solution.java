package m57v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Glory
 * @date 2020/3/6 0:29
 */
public class Solution {

    public int[][] findContinuousSequence2(int target) {
        int[][] res = new int[target][target];
        int count = 0;
        for (int i = 1; i < target; i++) {
            int sum = i;
            int[] arr = new int[target];
            int count2 = 0;
            arr[count2++] = i;
            for (int j = i + 1; j < target; j++) {
                sum += j;
                arr[count2++] = j;
                if (sum == target) {
                    res[count++] = arr;
                    break;
                } else if (sum > target) {
                    break;
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int countLen = 0;
            for (int j = 0; j < target; j++) {
                if (res[i][j] > 0) {
                    countLen++;
                }
            }
            int[] ans = new int[countLen];
            System.arraycopy(res[i], 0, ans, 0, countLen);
            list.add(ans);
        }

        return list.toArray(new int[0][]);
    }

    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 1;
        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] arr = new int[i];
                for (int j = target / i, k = 0; j < target / i + i; j++, k++) {
                    arr[k] = j;
                }
                list.add(arr);
            }
        }
        Collections.reverse(list);

        //这里注意奥，为什么是0，看源码
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] continuousSequence = solution.findContinuousSequence(9);
        for (int i = 0; i < continuousSequence.length; i++) {
            System.out.println(Arrays.toString(continuousSequence[i]));
        }
    }

}
