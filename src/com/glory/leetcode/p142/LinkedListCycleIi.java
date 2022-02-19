package com.glory.leetcode.p142;

import com.glory.leetcode.util.ListNode;

/**
 * @author zhanggc
 * @date 2022-02-19 12:51:22
 */
public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }


    public static class Solution {
        /**
         * 当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，
         * 再次相遇时所在的节点位置就是环开始的位置。
         */
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }

            if (fast == null || fast.next == null) {
                // shows that there is no circle.
                return null;
            }

            slow = head;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
        }
    }

}
