package base;

public class No283 {
    public static void moveZeroes(int[] nums) {
        if (nums.length == 0)
            return;
        int left = 0, cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != 0) {
                int temp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = temp;
                left++;
            }
            cur++;
        }
    }

//    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
//        No283.moveZeroes(nums);
//        Tools.printArrays(nums);
//    }

}
