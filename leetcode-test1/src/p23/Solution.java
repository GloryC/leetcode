package p23;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Glory
 * @date 2020/4/26 15:02
 */
public class Solution {

    /**
     * 优先队列
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list == null) continue;
            priorityQueue.add(list);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode nextNode = priorityQueue.poll();
            cur.next = nextNode;
            cur = cur.next;
            if (nextNode.next != null) {
                priorityQueue.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

}
