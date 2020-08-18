package p109;

import util.ListNode;
import util.TreeNode;

/**
 * @author zhanggc
 * @date 2020/8/18 8:24
 */
public class Solution {
    /**
     * 快慢指针确定根节点
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        while (q != null && q.next != null) {
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }

        // 将链表从中间分开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}
