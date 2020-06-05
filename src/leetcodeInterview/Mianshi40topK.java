package leetcodeInterview;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Mianshi40topK {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        if (k == 0)
            return new int[0];
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0)
            return new int[0];
        quicksearch(arr, 0, arr.length-1, k);
        return Arrays.copyOf(arr, k);
    }

    private void quicksearch(int[] arr, int left, int right, int k) {
        if (left >= right)
            return;
        int i = left, j = right;
        int midValue = arr[left];
        while (i < j) {
            while (arr[i] <= midValue && i < right)
                i++;
            while (arr[j] >= midValue && j > left)
                j--;
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[j];
        arr[j] = midValue;
        if (j == k)
            return;
        quicksearch(arr, left, j-1, k);
        quicksearch(arr, j+1, right, k);
    }

}
