package p142;

import util.ListNode;

/**
 * 环形链表II
 *
 * @author Glory
 * @date 2019/9/7 9:25
 */
public class Solution {

    private ListNode getInterest(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode interest = getInterest(head);
        if (interest == null) {
            return null;
        }

        ListNode pt1 = head;
        ListNode pt2 = interest;
        while (pt1 != pt2) {
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        return pt1;
    }

}
