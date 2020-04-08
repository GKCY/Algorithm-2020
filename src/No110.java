import TreeTraversal.TreeNode;

public class No110 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//    自顶向上
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(getHeight(root.left)-getHeight(root.right)) <= 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // 自底向上
//    public boolean isBalanced(TreeNode root) {
//        return recur(root) != -1;
//    }
//
//    private int recur(TreeNode root) {
//        if (root == null)
//            return 0;
//        int left = recur(root.left);
//        if (left == -1) return -1;
//        int right = recur(root.right);
//        if (right == -1) return -1;
//        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
//    }
}
