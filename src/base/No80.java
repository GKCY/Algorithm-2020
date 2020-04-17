package base;

public class No80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0;
        int count = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] == nums[l])
                count++;
            else
                count = 1;
            if (count <= 2)
                nums[++l] = nums[r];
        }
        return l+1;
    }
}
