import java.util.HashMap;

public class No337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // 解法一
//    HashMap<TreeNode, Integer> mem = new HashMap<>();
//    public int rob(TreeNode root) {
//        if (root == null)
//            return 0;
//        if (mem.containsKey(root))
//            return mem.get(root);
//        int doRob = root.val + (root.left == null ? 0 :rob(root.left.left)+rob(root.left.right))
//                + (root.right == null ? 0 : rob(root.right.left)+rob(root.right.right));
//        int undoRob = rob(root.left) + rob(root.right);
//        int res = Integer.max(doRob, undoRob);
//        mem.put(root, res);
//        return res;
//    }
    public int rob(TreeNode root) {
        int[] res = robInternal(root);
        return Integer.max(res[0], res[1]);
    }

    public int[] robInternal(TreeNode root) {
        int[] res = new int[2];
        if (root == null)
            return res;
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        //0抢 1不抢
        res[0] = root.val + left[1] + right[1];
        res[1] = Integer.max(left[0], left[1]) + Integer.max(right[0], right[1]);
        return res;
    }

}
