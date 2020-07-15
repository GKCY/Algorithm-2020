package tool;

import DS.ListNode;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;


public class Utils {
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

    static public void printMatrix(boolean[][] dp) {
        int m = dp.length;
        int n = dp[0].length;
        System.out.print("\t");
        for (int i = 0; i < n; i++)
            System.out.print(i + "\t");
        System.out.print("\n");
        for (int i = 0; i < m; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < n; j++) {
                String s = dp[i][j] ? String.valueOf("T") : String.valueOf("F");
                System.out.print(s + "\t");
            }
            System.out.print("\n");
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


    public static void printBooleanMatrix(boolean[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                builder.append(matrix[i][j]);
                builder.append("\t");
            }
            System.out.println(builder.toString());
            builder.delete(0, builder.length());
        }
    }

    public static void printArrays(Object[] o) {
        System.out.println(Arrays.toString(o));
    }

    public static void printArrays(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void printArrays(int[] nums, int n) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < n; i++) {
            if (i != 0)
                builder.append(",");
            builder.append(String.valueOf(nums[i]));
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static void printArrays(boolean[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8};
        int[] cp = new int[]{nums[0],1,4};
        Utils.printArrays(cp);
    }


}
