public class No33 {
    class solution1 {
        public int search(int[] nums, int target) {
            if (nums.length == 0)
                return -1;
            int index = findIndex(nums);
            int l = search(index, nums.length - 1, nums, target);
            int r = search(0, index - 1, nums, target);
            if (l != -1)
                return l;
            if (r != -1)
                return r;
            return -1;
        }

        public int findIndex(int[] nums) {
            int left = 0, right = nums.length-1;
            if (nums[left] <= nums[right])
                return 0;
            while (left <= right){
                int mid = (left + right)/2;
                if (nums[mid] > nums[mid+1])
                    return mid+1;
                else {
                    if (nums[mid] < nums[left])
                        right = mid - 1;
                    else if (nums[mid] >= nums[left])
                        left = mid + 1;
                }
            }
            return 0;
        }

        public int search(int left, int right, int[] nums, int target){
            while (left <= right){
                int mid = (left+right)/2;
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] < target)
                    left = mid+1;
                else
                    right = mid-1;
            }
            return -1;
        }
    }


    class solution2 {
        public int search(int[] nums, int target) {
            if (nums.length == 0)
                return -1;
            int left = 0, right = nums.length-1;
            while (left <= right) {
                int mid = (left+right)/2;
                if (nums[mid] == target)
                    return mid;
                if (nums[left] < nums[mid]) {
                    if (target < nums[mid] && target >=nums[left])
                        right = mid - 1;
                    else
                        left = mid+1;
                } else {
                    if (target <= nums[right] && target > nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}

