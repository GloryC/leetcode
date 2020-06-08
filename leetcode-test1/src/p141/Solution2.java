package p141;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @author Glory
 * @date 2019/9/7 9:25
 */
public class Solution2 {

    /**
     * 使用set记录是否出现重复节点
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            } else {
                nodes.add(head);
                head = head.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(l1));
    }

}
