import DS.TreeNode;
import tool.Tools;

import java.util.*;
import java.util.concurrent.*;



public class Test {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid+1])
                l = mid + 1;
            else if (nums[mid] >= nums[mid+1])
                r = mid;
        }
        return nums[r];
    }



    public static void main(String[] args) {
        System.out.println();
    }

}



