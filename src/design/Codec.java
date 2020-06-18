package design;

import DS.TreeNode;
import tool.Tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        LinkedList<String> builder = new LinkedList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node == null)
//                builder.add("#");
//            else {
//                builder.add(String.valueOf(node.val));
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }
//        }
//        return String.join(",", builder);
//    }


    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        System.out.println(data);
//        String[] split = data.split(",");
//        HashMap<Integer, TreeNode> map = new HashMap<>();
//        for (int i = split.length; i >= 1; i--) {
//            String str = split[i-1];
//            TreeNode node;
//            node = str.equals("#") ? null : new TreeNode(Integer.parseInt(str));
//            if (node != null) {
//                node.left = i * 2 > data.length() ? null : map.get(i * 2);
//                node.right = i * 2 + 1 > data.length() ? null : map.get(i * 2 + 1);
//            }
//            map.put(i, node);
//        }
//        return map.get(1);
//    }

    public String serialize(TreeNode root){
        StringBuilder builder = new StringBuilder();
        if (root == null)
            return "#,";
        else {
            builder.append(String.valueOf(root.val));
            builder.append(",");
            String left = serialize(root.left);
            String right = serialize(root.right);
            builder.append(left);
            builder.append(right);
        }
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
        return deserialize(list);
    }

    public TreeNode deserialize(LinkedList<String> list) {
        if (list.getFirst().equals("#")) {
            list.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.poll()));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    public static void main(String[] args) {
        //[5,2,3,null,null,2,4,3,1]
        TreeNode node = new TreeNode(-1);
        node.left = new TreeNode(0);
        node.right = new TreeNode(1);
        Codec codec = new Codec();
        String str = codec.serialize(node);
        TreeNode root = codec.deserialize(str);
        System.out.println(str);
        System.out.println(codec.serialize(root));
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));