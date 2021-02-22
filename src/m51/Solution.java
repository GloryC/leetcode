package m51;

/**
 * @author Glory
 * @date 2020/4/24 14:07
 */
public class Solution {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if(left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);

        return mergeSort(nums, left, mid) +
                mergeSort(nums, mid + 1, right) +
                merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int p1 = left, p2 = mid + 1;
        int ans = 0, i = 0;
        int[] mergeArray = new int[right - left + 1];

        while(p1 <= mid && p2 <= right) {
            ans += nums[p1] > nums[p2] ? right - p2 + 1 : 0;
            mergeArray[i++] = nums[p1] > nums[p2] ? nums[p1++] : nums[p2++];
        }
        while(p1 <= mid) {
            mergeArray[i++] = nums[p1++];
        }
        while(p2 <= right) {
            mergeArray[i++] = nums[p2++];
        }

        for(int j = 0; j < mergeArray.length; j++) {
            nums[left + j] = mergeArray[j];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] data = {7, 5, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(data));
    }
}
