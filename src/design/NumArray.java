package design;

import tool.Tools;

public class NumArray {
    int[] nums;
    int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[2 * nums.length];
        for (int i = nums.length; i < tree.length; i++)
            tree[i] = nums[i - nums.length];
        for (int i = nums.length - 1; i > 0; i--)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
//        Tools.printArrays(tree);
    }

    public void update(int i, int val) {
        int n = i + nums.length;
        tree[n] = val;
        int left, right;
        while (n > 0) {
            left = right = n;
            if (n % 2 == 0)
                right = n + 1;
            else
                left = n - 1;
            tree[left / 2] = tree[left] + tree[right];
            n = left / 2;
        }
//        Tools.printArrays(tree);
    }

    public int sumRange(int i, int j) {
        int left = i + nums.length, right = j + nums.length;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1)
                sum += tree[left++];
            if (right % 2 == 0)
                sum += tree[right--];
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        NumArray numArray = new NumArray(nums);
//        numArray.update(2, 6);
        System.out.println(numArray.sumRange(0, 4));
    }
}
