package leetcodeInterview;

import DS.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mianshi02dot01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            set.add(cur.val);
            ListNode ptr = cur.next;
            while (ptr != null && set.contains(ptr.val))
                ptr = ptr.next;
            cur.next = ptr;
            cur = ptr;
        }
        return dummy.next;
    }
}
