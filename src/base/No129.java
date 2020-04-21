package base;

import DS.TreeNode;

public class No129 {

    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root != null)
            travelsal(root, 0);
        return res;
    }

    public void travelsal(TreeNode root, int sum) {
        int temp = sum * 10 + root.val;
        if (root.left == null && root.right == null)
            res += temp;
        if (root.left != null)
            travelsal(root.left, temp);
        if (root.right != null)
            travelsal(root.right, temp);
    }
}
