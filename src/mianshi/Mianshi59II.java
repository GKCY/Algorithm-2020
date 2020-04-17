package mianshi;

import java.util.LinkedList;
import java.util.Queue;

public class Mianshi59II {
    Queue<Integer> queue;
    int max, num;
    public Mianshi59II() {
        queue = new LinkedList<>();
        num = 0;
        max = Integer.MIN_VALUE;
    }

    public int max_value() {
        if (queue.isEmpty())
            return -1;
        else
            return max;
    }

    public void push_back(int value) {

    }

    public int pop_front() {
        return 0;
    }
}
