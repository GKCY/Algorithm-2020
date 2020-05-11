package base;

import DS.TreeNode;

public class No654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return create(nums, 0, nums.length-1);
    }

    public TreeNode create(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, start, mid-1);
        root.right = create(nums, mid+1, end);
        return root;
    }

    public int findMax(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int k = i; k <= j; k++) {
            if (nums[k] > max) {
                index = k;
                max = nums[k];
            }
        }
        return index;
    }
}
