package base;

public class No75 {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length-1;
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, cur, p0);
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
            } else {
                cur++;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
