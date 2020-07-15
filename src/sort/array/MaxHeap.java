package sort.array;

import tool.Utils;

public class MaxHeap {
    public int[] nums;
    private int size = 0;

    public MaxHeap(int capacity) {
        this.nums = new int[capacity + 1];
    }

    public int max() {
        return nums[1];
    }

    public void add(int num) {
        nums[++size] = num;
        rise(size);
//        Utils.printArrays(nums, size+1);
    }

    public int poll() {
        swap(1, size);
        size--;
        sink(1);
//        Utils.printArrays(nums, size+1);
        return nums[size+1];
    }

    private void rise(int cur) {
        int parent = cur / 2;
        while (cur > 1 && nums[parent] < nums[cur]) {
            swap(parent, cur);
            cur = parent;
            parent /= 2;
        }
    }

    private void sink(int cur) {
        int left = cur * 2;
        int right = cur * 2 + 1;
        while (left <= size) {
            int older = left;
            if (right <= size && nums[right] >= nums[left])
                older = right;
            if (nums[cur] > nums[older])
                break;
            swap(cur, older);
            cur = older;
            left = cur * 2;
            right = cur * 2 + 1;
        }
    }


    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,4,5,3,2,0,-1};
        MaxHeap maxHeap = new MaxHeap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            maxHeap.poll();
        }

        Utils.printArrays(maxHeap.nums);

    }

}
