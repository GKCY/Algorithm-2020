package base;

import DS.ListNode;
import DS.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class No109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        if (head == mid)
            return root;
        root.right = sortedListToBST(mid.next);
        root.left = sortedListToBST(head);
        return root;
    }

    public ListNode findMid(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null)
            pre.next = null;
        return slow;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return convertToTree(list, 0, list.size()-1);
    }

    private TreeNode convertToTree(ArrayList<Integer> list, int i, int j) {
        if (i > j)
            return null;
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = convertToTree(list, i, mid-1);
        node.right = convertToTree(list, mid+1, j);
        return node;
    }
}
