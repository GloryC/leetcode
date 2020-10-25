package p143;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2020/10/20 9:00
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) break;
            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;
    }
}
