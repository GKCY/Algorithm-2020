import java.util.Arrays;

public class No16 {
    // 0 2 1 -3
    static public int threeSumClosest(int[] nums, int target) {
        int distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int left, right;
        int res=0;
        for (int i = 0; i < nums.length - 1; i++) {
            left = i+1;
            right = nums.length-1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                int value = Math.abs(sum-target);
                if (value < distance){
                    res = sum;
                    distance = value;
                }
                if (sum < target)
                    left++;
                if (sum > target)
                    right--;
                if (sum == target){
                    res = sum;
                    distance = 0;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        System.out.println(No16.threeSumClosest(nums, 82));
    }
}
