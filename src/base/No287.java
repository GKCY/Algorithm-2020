package base;

public class No287 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        int ptr = 0;
        while (true) {
            ptr = nums[ptr];
            slow = nums[slow];
            if (slow == ptr) break;
        }
        return ptr;
    }

    public int findDuplicate2(int[] nums) {
        int left = 1, right = nums.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid)
                    cnt++;
            }

            if (cnt <= mid)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }
}
