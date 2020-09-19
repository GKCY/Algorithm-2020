import DS.TreeNode;

public class solution {

    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(isValidBST(root.left)) {
            if(pre == null) {
                pre = root;
                System.out.println(root.val);
                return true;
            } else if(root.val > pre.val) {
                System.out.println(root.val);
                pre = root;
            }
            return isValidBST(root.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        solution t = new solution();
        t.isValidBST(root);
    }
}
