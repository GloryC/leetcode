package p147;

/**
 * @author Glory
 * @date 2020/3/4 21:59
 */
public class Solution {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 对链表进行插入排序。
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = head;
        ListNode q = head.next;
        ListNode fake = new ListNode(-1);
        while (q != null) {
            int temp = q.val;
            // 如果上一位已经比它小了，表示已经排好顺序了，不用排
            if (p.val < temp) {
                q = q.next;
                p = p.next;
            } else {
                // 直接先讲p连到后面
                p.next = q.next;
                ListNode f = fake;
                // 肯定会碰到那个比他大的，不然就不会进入这里饿了
                while (f.next.val < q.val) {
                    f = f.next;
                }
                // 插入完成
                q.next = f.next;
                f.next = q;
                // 重置p指针
                q = p.next;
            }
        }
        return fake.next;
    }


}
