package p152;

/**
 * @author Glory
 * @date 2020/5/18 8:47
 */
public class Solution2 {

    /**
     * tmp<0时交换最大值和最小值
     */
    public int maxProduct(int[] nums) {
        // 一个保存最大的，一个保存最小的。
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            // 如果数组的数是负数，那么会导致最大的变最小的，
            // 最小的变最大的。因此交换两个的值。
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {-2, 3, -4};
        System.out.println(solution.maxProduct(nums));
    }
}
