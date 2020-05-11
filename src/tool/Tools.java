package tool;

import DS.ListNode;


public class Tools {
    static public ListNode createLinkedlist(int[] nums) {
        ListNode head = null;
        for (int i = nums.length-1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = head;
            head = node;
        }
        return head;
    }

    static public void printLinkedlist(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            builder.append(" ");
            head = head.next;
        }
        System.out.println(builder.toString());
    }

    static public void printArrays(int[] nums) {
        StringBuilder res = new StringBuilder();
        res.append("{");
        for (int num :
                nums) {
            res.append(String.valueOf(num));
            res.append(',');
        }
        res.delete(res.length()-1, res.length());
        res.append('}');
        System.out.println(res.toString());
    }


    /** matrix非空 */
    static public void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                builder.append(matrix[i][j]);
                builder.append(" ");
            }
            System.out.println(builder.toString());
            builder.delete(0, builder.length());
        }
    }

    static public void printTwoDimensionalArray(int[][] arrays) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int[] array :
                arrays) {
            builder.append("[");
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i]);
                if (i < array.length - 1)
                    builder.append(",");
            }
            builder.append("]");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    static public void printBooleanArrays(boolean[] nums) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (boolean num :
                nums) {
            res.append(String.valueOf(num));
            res.append('\t');
        }
        res.delete(res.length()-1, res.length());
        res.append(']');
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
    }
}
