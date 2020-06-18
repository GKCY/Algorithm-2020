package base;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class No5423 {
    private static class pair {
        int size;
        int y;

        public pair(int size, int y) {
            this.size = size;
            this.y = y;
        }
    }
    public static int minSumOfLengths(int[] arr, int target) {
        LinkedList<pair> pq = new LinkedList<>();
        int left = 0, right = 0;
        int sum = 0;
        while (right < arr.length) {
            sum += arr[right++];
            while (sum > target)
                sum -= arr[left++];
            if (sum == target) {
                int size = right - left;
                int y = right - 1;
                if (!pq.isEmpty()){
                    if (left <= pq.getLast().y && size < pq.getLast().size) {
                        pq.removeLast();
                        pq.offer(new pair(size, y));
                    } else if (left <= pq.getLast().y && size == pq.getLast().size)
                        ;
                    else
                        pq.offer(new pair(size, y));
                } else
                    pq.offer(new pair(size, y));

                sum = 0;
                left = left + 1;
                right = left;
            }
        }
        pq.sort((a, b) -> a.size - b.size);
        return pq.size() < 2 ? -1 :pq.poll().size + pq.poll().size;

    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,4,3};
        int target = 3;
        System.out.println(No5423.minSumOfLengths(nums, target));
    }
}
