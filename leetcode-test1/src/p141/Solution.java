package p141;

import util.ListNode;

/**
 * 环形链表
 *
 * @author Glory
 * @date 2019/9/7 9:25
 */
public class Solution {

    /**
     * 不带头结点的版本，模拟第一次后的数据，fast = head.next;
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
