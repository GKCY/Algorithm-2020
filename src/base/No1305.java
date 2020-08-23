package base;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                res.add(l1.get(i++));
            } else
                res.add(l2.get(j++));
        }

        for (int k = i; k < l1.size(); k++) {
            res.add(l1.get(k));
        }

        for (int k = j; k < l2.size(); k++) {
            res.add(l2.get(k));
        }

        return res;
    }

    public void inorder(TreeNode root, List<Integer> l1) {
        if (root == null)
            return;
        inorder(root.left, l1);
        l1.add(root.val);
        inorder(root.right, l1);
    }
}
