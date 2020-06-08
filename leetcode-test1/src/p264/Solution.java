package p264;

/**
 * @author Glory
 * @date 2020/3/10 21:58
 */
public class Solution {

    /**
     * 三指针法
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int temp;

        for (int i = 1; i < n; i++) {
            temp = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = temp;

            if (temp == nums[i2] * 2) {
                i2++;
            }
            if (temp == nums[i3] * 3) {
                i3++;
            }
            if (temp == nums[i5] * 5) {
                i5++;
            }
        }

        return nums[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1600));
    }

}
