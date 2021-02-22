package p24;

import util.ListNode;

/**
 * @author Glory
 * @date 2020/5/18 10:12
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode a = head;
            ListNode b = head.next;

            // swap
            pre.next = b;
            a.next = b.next;
            b.next = a;

            pre = a;
            head = a.next;

        }
        return dummy.next;
    }
}
