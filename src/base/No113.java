package base;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            temp.add(root.val);
            backtrack(root, root.val, sum);
            temp.remove(temp.size()-1);
        }
        return res;
    }

    public void backtrack(TreeNode root, int target, int sum){
        if (target == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (root.left != null) {
            temp.add(root.left.val);
            backtrack(root.left, target + root.left.val, sum);
            temp.remove(temp.size()-1);
        }

        if (root.right != null) {
            temp.add(root.right.val);
            backtrack(root.right, target + root.right.val, sum);
            temp.remove(temp.size()-1);
        }
    }
}
