package p83;

import util.ListNode;

/**
 * @author Glory
 * @date 2020/3/24 18:09
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }

}
