import DS.tNode;
import DS.TreeNode;
import base.No127;
import tool.Tools;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Pattern;


public class Test {


    public static int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] == target)
                r = mid;
            else if (nums[mid] > target)
                r = mid;
            else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (l == nums.length)
            return -1;
        return nums[r] == target ? r : -1;
    }
    public static void main(String[] args){
        for (int i = Integer.MAX_VALUE - 1; i <= Integer.MAX_VALUE;i++)
            System.out.println(i);
    }

}



