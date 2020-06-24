package design;

import java.util.PriorityQueue;

public class MedianFinder {
    /** initialize your data structure here. */
    private boolean odd;
    private PriorityQueue<Integer> front;
    private PriorityQueue<Integer> behind;
    public MedianFinder() {
        odd = false;
        front = new PriorityQueue<>((a, b) -> b - a);
        behind = new PriorityQueue<>();
    }

    public void addNum(int num) {
        odd = !odd;
        if (front.isEmpty() || num <= front.peek()) {
            front.add(num);
            if (!odd)
                behind.add(front.poll());
        }
        else {
            behind.add(num);
            if (odd)
                front.add(behind.poll());
        }
    }

    public double findMedian() {
        if (odd)
            return front.peek() * 1.0;
        else
            return (front.peek() + behind.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder t = new MedianFinder();
        t.addNum(1);
        t.addNum(2);
        t.addNum(3);
        System.out.println(t.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
