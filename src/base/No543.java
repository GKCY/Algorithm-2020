package base;

public class No543 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        depth(root);
        return max;
    }
    public int depth(TreeNode root){
        if (root == null)
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        if (l+r > max)
            max = l+r;
        return Math.max(l, r)+1;
    }
}
