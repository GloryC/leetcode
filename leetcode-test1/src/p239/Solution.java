package p239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 思路：双端队列
 *
 * @author Glory
 * @date 2020/6/8 15:49
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 删除队列中小于窗口左边下标的元素
            if (i >= k && i - k + 1 > deque.peek())
                deque.remove();

            // 从队列右侧开始, 删除小于nums[i] 的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.removeLast();

            deque.add(i);

            // 队列左侧是最大值,加入结果
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));
    }

}
