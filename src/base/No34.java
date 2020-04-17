package base;

public class No34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {findLeft(nums, target), findRight(nums, target)};
        return res;
    }

    public int findLeft(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                right = mid-1;
            } else if (nums[mid] > target){
                right = mid-1;
            } else if (nums[mid] < target){
                left = mid+1;
            }
        }
        if (left == nums.length)
            return -1;
        return target == nums[left] ? left : -1;
    }

    public int findRight(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                left = mid+1;
            } else if (nums[mid] > target){
                right = mid-1;
            } else if (nums[mid] < target){
                left = mid+1;
            }
        }
        if (right == -1)
            return -1;
        return nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        No34 t = new No34();
        int[] nums = {5,7,7,8,8,10};
        System.out.println(t.findLeft(nums, 6));
        System.out.println(t.findRight(nums, 6));
    }

}
