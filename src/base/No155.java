package base;

import DS.MinStack;

public class No155 extends MinStack {

    //test
    public static void main(String[] args) {
        No155 stack = new No155();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.getMin());
    }
}
