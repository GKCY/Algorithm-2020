import DS.ListNode;

public class Tools {
    static public ListNode createLinkedlist(int[] nums) {
        ListNode head = null;
        for (int i = nums.length-1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = head;
            head = node;
        }
        return head;
    }

    static public void printLinkedlist(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            builder.append(" ");
            head = head.next;
        }
        System.out.println(builder.toString());
    }

    static public void printArrays(int[] nums){
        StringBuilder res = new StringBuilder();
        res.append("{");
        for (int num :
                nums) {
            res.append(String.valueOf(num));
            res.append(',');
        }
        res.delete(res.length()-1, res.length());
        res.append('}');
        System.out.println(res.toString());
    }
}
