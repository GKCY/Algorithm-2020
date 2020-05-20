package base;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class No138 {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public void print() {
            Node head = this;
            StringBuilder builder = new StringBuilder();
            while (head != null) {
                builder.append(head.val);
                builder.append(" ");
                head = head.next;
            }
            System.out.println(builder.toString());
        }
    }

    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList1(Node head) {
        if (head == null)
            return null;
        if (map.containsKey(head))
            return map.get(head);
        Node clone = new Node(head.val);
        map.put(head, clone);
        clone.next = copyRandomList1(head.next);
        clone.random = copyRandomList1(head.random);
        return clone;
    }

    public Node copyRandomList2(Node head) {
        if (head == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> pair = new HashMap<>();
        pair.put(null, null);
        Node clone = new Node(head.val);
        pair.put(head, clone);
        queue.offer(head);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (!pair.containsKey(temp.next)) {
                pair.put(temp.next, new Node(temp.next.val));
                queue.offer(temp.next);
            }
            if (!pair.containsKey(temp.random)) {
                pair.put(temp.random, new Node(temp.random.val));
                queue.offer(temp.random);
            }
            pair.get(temp).next = pair.get(temp.next);
            pair.get(temp).random = pair.get(temp.random);
        }
        return pair.get(head);
    }

    public Node copyRandomList3(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random == null)
                cur.next.random = null;
            else
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        Node cloneHead = head.next;
        cur = cloneHead;
        while (cur.next != null) {
            head.next = cur.next;
            head = head.next;

            cur.next = cur.next.next;
            cur = cur.next;
        }
        head.next = null;
        return cloneHead;
    }
}
