package base;

public class No376 {
    public int wiggleMaxLength1(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            max[i] = min[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    max[i] = Math.max(max[i], min[j]+1);
                if (nums[j] > nums[i])
                    min[i] = Math.max(min[i], max[j]+1);
            }
        }
        return Math.max(max[nums.length-1], min[nums.length-1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])
                up = down + 1;
            if (nums[i] < nums[i-1])
                down = up + 1;
        }
        return Math.max(down, up);
    }

    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(new No376().wiggleMaxLength2(nums));
    }
}
