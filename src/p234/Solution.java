package p234;

import util.ListNode;

/**
 * @author Glory
 * @date 2019/9/6 22:49
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head, dummy = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        assert slow.next != null;
        slow = reverse(slow.next);

        while (slow != null) {
            if (slow.val != dummy.val) {
                return false;
            }
            slow = slow.next;
            dummy = dummy.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
