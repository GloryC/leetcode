package m0201;

import util.ListNode;

/**
 * @author Glory
 * @date 2020/6/26 9:51
 */
public class Solution2 {

    /**
     * 方法2：二重循环
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }
        return head;
    }
}
