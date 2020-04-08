package TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return res;
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }
}
