package m0201;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Glory
 * @date 2020/6/26 9:51
 */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode tmp = head;
        while (tmp.next != null) {
            if (set.contains(tmp.next.val)) {
                tmp.next = tmp.next.next;
            } else {
                set.add(tmp.next.val);
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateNodes(l1));
    }
}
