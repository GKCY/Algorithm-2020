import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class No225 {
    class MyStack {

        LinkedList<Integer> list;
        int top;

        /** Initialize your data structure here. */
        public MyStack() {
            list = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int size = list.size();
            list.add(x);
            top = x;
            for (int i = 0; i < size; i++) {
                int head = list.get(0);
                list.remove(0);
                list.add(head);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int head = top;
            list.remove(0);
            if (!list.isEmpty())
                top = list.get(0);
            return head;
        }

        /** Get the top element. */
        public int top() {
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return list.isEmpty();
        }
    }
}
