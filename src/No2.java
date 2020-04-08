public class No2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, flag = 0;
        ListNode head = null, node = null;

        while (l1 != null || l2 != null){
            if (l1 == null){
                sum = l2.val + flag;
                l2 = l2.next;
            }else if (l2 == null){
                sum = l1.val + flag;
                l1 = l1.next;
            }else {
                sum = l1.val + l2.val + flag;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (sum > 9) {
                flag = sum / 10;
                sum = sum % 10;
            } else {
                flag = 0;
            }
            if (head == null){
                head = new ListNode(sum);
                head.next = null;
                node = head;
            } else {
                node.next = new ListNode(sum);
                node = node.next;
                node.next = null;
            }
        }
        if(flag != 0){
            node.next = new ListNode(flag);
            node.next.next = null;
        }
        return head;
    }
}

