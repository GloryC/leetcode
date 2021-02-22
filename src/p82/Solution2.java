package p82;

import util.ListNode;

import javax.management.StandardEmitterMBean;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Glory
 * @date 2020/3/24 18:17
 */
public class Solution2 {

    /**
     * others method
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
