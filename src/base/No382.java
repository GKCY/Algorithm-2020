package base;

import DS.ListNode;

import java.util.Random;

public class No382 {

    ListNode head;
    Random rand;

    public void Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        int res = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            int randNum = rand.nextInt(count);
            if (randNum == 0)
                res = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
