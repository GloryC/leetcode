package p33;

/**
 * @author Glory
 * @date 2019/9/18 9:58
 */
public class Solution {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                low = mid + 1;
            } else if (target > nums[mid] && target < nums[0]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low == high && nums[low] == target ? low : -1;

    }

}
