package base;

public class No41 {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        int i = 0;
        while (i < N) {
            if (nums[i] == i + 1 || nums[i] > N || nums[i] <= 0
                    || nums[nums[i] - 1] == nums[i])
                i++;
            else {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int j = 0; j < N; j++) {
            if (j + 1 != nums[j])
                return j + 1;
        }
        return N + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new No41().firstMissingPositive(nums));
    }
}
