package p315;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/7/11 15:55
 */
public class Solution {

    private int[] index;
    private int[] helper;
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);

        index = new int[nums.length];
        helper = new int[nums.length];
        count = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        merge(nums, 0, nums.length - 1);

        for (int i = 0; i < count.length; i++) {
            res.add(i, count[i]);
        }
        return res;
    }

    private void merge(int[] nums, int s, int e) {
        if (s == e || s > e) return;
        int mid = (s + e) >> 1;

        if (s < mid) {
            merge(nums, s, mid);
        }

        if (mid + 1 < e) {
            merge(nums, mid + 1, e);
        }

        int i = s, j = mid + 1;
        int hi = s;
        while (i <= mid && j <= e) {
            if (nums[index[i]] <= nums[index[j]]) {
                // 右侧出
                helper[hi++] = index[j++];
            } else {
                // 左侧出 计数
                count[index[i]] += e - j + 1;
                helper[hi++] = index[i++];
            }
        }

        while (i <= mid) {
            //左侧出
            helper[hi++] = index[i++];
        }

        while (j <= e) {
            // 右侧出
            helper[hi++] = index[j++];
        }

        if (e + 1 - s >= 0)
            System.arraycopy(helper, s, index, s, e + 1 - s);
    }

}
