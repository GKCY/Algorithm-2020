import java.util.ArrayList;
import java.util.Stack;

public class No98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


//    public boolean isValidBST(TreeNode root) {
////        ArrayList<Integer> list = new ArrayList<>();
////        isValidate(root, list);
////        for (int i = 1; i < list.size(); i++) {
////            if (list.get(i) <= list.get(i-1))
////                return false;
////        }
////        return true;
////    }
////
////    public void isValidate(TreeNode root, ArrayList<Integer> list) {
////        if (root == null)
////            return;
////        isValidate(root.left, list);
////        list.add(root.val);
////        isValidate(root.right, list);
////    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
         TreeNode pre = null;
         while (root != null || !stack.empty()) {
             while (root != null) {
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
             if (pre != null && root.val < pre.val)
                 return false;
             pre = root;
             root = root.right;
         }
        return true;
    }

//    TreeNode pre = null;
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        if (!isValidBST(root.left)) return false;
//        if (pre != null && pre.val >= root.val) return false;
//        pre = root;
//        return isValidBST(root.right);
//    }
}
