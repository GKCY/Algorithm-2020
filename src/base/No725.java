package base;

import DS.ListNode;

public class No725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int size = 0;
        ListNode cur = root;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int count = size % k;
        for (int i = 1; i <= k; i++) {
            int length = i <= count ? size / k + 1 : size / k;
            if (length == 0) {
                res[i-1] = null;
                continue;
            }
            cur = root;
            for (int j = 0; j < length - 1; j++)
                cur = cur.next;
            res[i-1] = root;
            root = cur.next;
            cur.next = null;
        }
        return res;
    }
}
