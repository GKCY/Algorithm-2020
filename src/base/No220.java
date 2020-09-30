package base;

import java.util.TreeSet;

public class No220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            if (treeSet.size() > k)
                treeSet.remove((long)nums[i-k-1]);
            Long s = treeSet.ceiling(num - t);
            if (s != null && s <= num + t)
                return true;
            treeSet.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        int k = 2;
        int t = 3;
        System.out.println(new No220()
                .containsNearbyAlmostDuplicate(nums, k, t));
    }

}
