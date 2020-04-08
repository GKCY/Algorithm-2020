import javax.swing.*;

public class Quicksort {
    public static void quickSort(int[] arr){
        partition(arr, 0, arr.length-1);
    }

    private static void partition(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int i = left, j = right;
        int target = arr[left];
        while (i < j) {
            while (arr[i] <= target && i < right)
                i++;
            while (arr[j] >= target && j > left)
                j--;
            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, j, left);
        partition(arr, left, j-1);
        partition(arr, j+1, right);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
