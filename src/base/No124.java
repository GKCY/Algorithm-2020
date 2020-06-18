package base;

import DS.TreeNode;

import java.util.Stack;

public class No124 {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return res;
    }

    public int maxSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(maxSum(root.left), 0);
        int right = Math.max(maxSum(root.right), 0);
        res = Math.max(left + right + root.val, res);

        return Math.max(left, right) + root.val;
    }
}
