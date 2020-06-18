package base;

import java.util.Arrays;

public class No1300 {
    public int findBestValue1(int[] arr, int target) {
        Arrays.sort(arr);
        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;
        for (int i = 1; i <= arr.length; i++)
            prefix[i] = prefix[i - 1] + arr[i - 1];
        int res = 0, value = Integer.MAX_VALUE;
        for (int i = 0; i <= arr[arr.length - 1]; i++) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0)
                index = -index - 1;
            int v = prefix[index] + i * (arr.length - index);
            if (Math.abs(v - target) < value) {
                value = Math.abs(v - target);
                res = i;
            }
        }
        return res;
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;
        for (int i = 1; i <= arr.length; i++)
            prefix[i] = prefix[i - 1] + arr[i - 1];
        int l = 0, r = arr[arr.length - 1];
        while (l < r) {
            int mid = (l + r) / 2;
            if (calculate(arr, prefix, mid, target) >= 0)
                r = mid;
            else
                l = mid + 1;
        }
        int v1 = -calculate(arr, prefix, l - 1, target);
        int v2 = calculate(arr, prefix, l, target);
        return v1 <= v2 ? l - 1 : l;
    }

    public int calculate(int[] arr, int[] prefix, int n, int target) {
        int index = Arrays.binarySearch(arr, n);
        if (index < 0)
            index = -index - 1;
        int v = prefix[index] + n * (arr.length - index);
        return v - target;
    }

    public static void main(String[] args) {
        int[] nums = {60864,25176,27249,21296,20204};
        int target = 56803;
        System.out.println(new No1300().findBestValue(nums, target));
    }
}
