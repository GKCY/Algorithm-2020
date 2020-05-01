package base;

public class No162 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid+1])
                l = mid + 1;
            else if (nums[mid] > nums[mid+1])
                r = mid;
        }
        return r;
    }
}
