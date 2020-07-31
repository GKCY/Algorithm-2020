package leetcodeInterview;

public class Mianshi08dot03 {
    public int findMagicIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i)
                return i;
        }
        return -1;
    }

    public int getAnswer(int[] nums, int start, int end) {
        if (start > end)
            return -1;
        int l = start, r = end;
        int mid = (l + r) / 2;
        int pre = getAnswer(nums, start, mid - 1);
        if (pre != -1)
            return pre;
        if (nums[mid] == mid)
            return mid;
        return getAnswer(nums, mid + 1, end);
    }

    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length-1);
    }
}
