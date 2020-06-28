package p209;

/**
 * @author Glory
 * @date 2020/6/28 8:39
 */
public class Solution {
    /**
     * 2，使用队列相加（实际上我们也可以把它称作是滑动窗口）
     * 我们把数组中的元素不停的入队，直到总和大于等于s为止
     * 接着记录下队列中元素的个数，然后再不停的出队，直到队列中元素的和小于s为止
     * （如果不小于s，也要记录下队列中元素的个数，这个个数其实就是不小于s的连续子数组长度，
     * 我们要记录最小的即可）。接着再把数组中的元素添加到队列中……重复上面的操作，
     * 直到数组中的元素全部使用完为止。
     */
    public int minSubArrayLen(int s, int[] nums) {
        int low = 0, high = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (high < nums.length) {
            sum += nums[high++];
            while (sum >= s) {
                minLen = Math.min(minLen, high - low);
                sum -= nums[low++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, nums));
    }
}
