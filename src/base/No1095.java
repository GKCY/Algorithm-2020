package base;

public class No1095 {
    //第1095题数组简化版

    public int solution(int target, int[] nums){
        int mountain = findMountain(nums);
        int left = findLeft(nums, 0, mountain, target);
        int right = findright(nums, mountain+1, nums.length-1, target);
        if (left != -1)
            return left;
        if (right != -1)
            return right;
        return -1;
    }

    public int findMountain(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] > nums[mid]-1 && nums[mid] > nums[mid+1])
                return mid;
            else if (nums[mid] > nums[mid+1])
                r = mid - 1;
            else if (nums[mid] < nums[mid+1])
                l = mid + 1;
        }
        return -1;
    }

    public int findLeft(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
        }
        return -1;
    }

    public int findright(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                r = mid - 1;
            else if (nums[mid] > target)
                l = mid + 1;
        }
        return -1;
    }

}
