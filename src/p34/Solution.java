package p34;

import java.util.Arrays;

/**
 * @author zhanggc
 * @date 2020/8/7 15:38
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    private int findLeft(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length; // 注意
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
                // 因为我们的「搜索区间」是 [left, right) 左闭右开，所以当 nums[mid] 被检测之后，
                // 下一步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid) 或 [mid + 1, right)
            else if (nums[mid] > target) right = mid; // 注意
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    private int findRight(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length; // 注意
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] < target) left = mid + 1;
                // 因为我们的「搜索区间」是 [left, right) 左闭右开，所以当 nums[mid] 被检测之后，
                // 下一步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid) 或 [mid + 1, right)
            else if (nums[mid] > target) right = mid; // 注意
        }
        if (left == 0) return -1;
        // 因为我们对 left 的更新必须是 left = mid + 1，就是说 while 循环结束时，
        // nums[left] 一定不等于 target 了，而 nums[left-1] 可能是 target。
        // 因为收紧左侧边界时必须 left = mid + 1
        // 所以最后无论返回 left 还是 right，必须减一
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(nums, 5)));
    }

}
