package p82;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Glory
 * @date 2020/3/24 18:17
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Set<Integer> num = new HashSet<>();
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                num.add(temp.val);
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        ListNode headNull = new ListNode(-1);
        headNull.next = head;
        temp = headNull;
        while (headNull.next != null) {
            if (num.contains(headNull.next.val)){
                headNull.next = headNull.next.next;
            }else {
                headNull = headNull.next;
            }
        }
        return temp;
    }

}
