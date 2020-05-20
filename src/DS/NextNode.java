package DS;

public class NextNode {
    public NextNode next;
    public int val;

    public NextNode(int val){
        this.val = val;
        this.next = null;
    }

    public void print() {
        NextNode head = this;
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            builder.append(" ");
            head = head.next;
        }
        System.out.println(builder.toString());
    }
}
