package p33;

/**
 * @author Glory
 * @date 2019/9/18 9:58
 */
public class Solution2 {

    /**
     * 有序或部分有序的数组，基本使用二分法
     * 二分比较端点
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            // 右半段有序
            else if (nums[mid] < nums[high]) {
                if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
            // 左半段有序
            else {
                if (nums[low] <= target && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {4, 5, 6, 7, 0, 1, 2};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.search(data, 2));
    }

}
