package base;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res= new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (root == null)
            return res;
        search(root, temp, res);

        return res;
    }

    public void search(TreeNode root, ArrayList<Integer> temp, List<String> res) {
        temp.add(root.val);
        if (root.left == null && root.right == null)
            res.add(getString(temp));
        if (root.left != null)
            search(root.left, temp, res);
        if (root.right != null)
            search(root.right, temp, res);
        temp.remove(temp.size()-1);
    }

    public String getString(ArrayList<Integer> temp) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < temp.size(); i++) {
            if (i != 0)
                builder.append("->");
            builder.append(temp.get(i));
        }
        return builder.toString();
    }
}
