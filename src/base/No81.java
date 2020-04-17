package base;

public class No81 {
    public static boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
            } else if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(No81.search(new int[]{2,5,6,0,0,1,2}, 0));
    }
}
