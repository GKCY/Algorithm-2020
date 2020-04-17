package base;

public class No213 {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int pre = 0, cur = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int temp = Integer.max(cur, pre + nums[i]);
            pre = cur;
            cur = temp;
        }
        int notIncludeHead = cur;
        pre = 0;
        cur = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = Integer.max(cur, pre + nums[i]);
            pre = cur;
            cur = temp;
        }
        int notIncludeTail = cur;
        return Integer.max(notIncludeHead, notIncludeTail);
    }
}
