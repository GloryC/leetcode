package p142;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表II
 *
 * @author Glory
 * @date 2019/9/7 9:25
 */
public class Solution2 {

    public ListNode detectCycle(ListNode head) {
        ListNode node = head;
        Set<ListNode> nodes = new HashSet<>();
        while (node != null) {
            if (nodes.contains(node)) {
                return node;
            } else {
                nodes.add(node);
                node = node.next;
            }
        }
        return null;
    }

}
