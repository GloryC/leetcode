package p215;

import java.util.PriorityQueue;

/**
 * @author Glory
 * @date 2020/6/29 8:46
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, 2));
    }
}
