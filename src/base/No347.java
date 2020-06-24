package base;

import tool.Utils;

import java.util.*;

public class No347 {
    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        List<Integer>[] frequency = new List[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue(), num = entry.getKey();
            if (frequency[count] == null)
                frequency[count] = new ArrayList<>();
            frequency[count].add(num);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && res.size() < k; i--) {
            if (frequency[i] != null)
                res.addAll(frequency[i]);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        Utils.printArrays(No347.topKFrequent2(nums, 2));
    }
}
