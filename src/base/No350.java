package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No350 {
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            int count = map.getOrDefault(num , 0);
            if (count > 0) {
                map.put(num, --count);
                res.add(num);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
