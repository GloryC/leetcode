package p142;

import util.ListNode;

/**
 * 环形链表II
 *
 * @author Glory
 * @date 2019/9/7 9:25
 */
public class Solution3 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
