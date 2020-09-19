package base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class No491 {
    HashSet<Integer> set = new HashSet<>();
    ArrayList<Integer> tmp = new ArrayList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<String> o = new ArrayList<>();
    public List<List<Integer>> findSubsequences1(int[] nums) {
        if (nums.length < 2)
            return res;
        dfs(nums, 0);
        return res;
    }


    public void dfs(int[] nums, int start) {
        if (start == nums.length) {
            if (tmp.size() >= 2 && legal(tmp)) {
                int hash = getHash(tmp);
                if (!set.contains(hash)) {
                    set.add(hash);
                    res.add(new ArrayList<>(tmp));
                    o.add(String.join("#",
                            tmp.stream().map(String::valueOf).collect(Collectors.toList())));
                }
            }
            return;
        }

        dfs(nums, start+1);
        tmp.add(nums[start]);
        dfs(nums, start+1);
        tmp.remove(tmp.size()-1);
    }

    public int getHash(List<Integer> nums) {
        int mod = (int) (1e9+7);
        int hash = 0;
        for (int num : nums) {
//            hash = hash * 263 % mod + (num + 101);
//            hash = hash % mod;
            hash = (hash * 101 + num + 101) % mod;
        }
        return hash;
    }

    public boolean legal(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i+1))
                return false;
        }
        return true;
    }

    ArrayList<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2)
            return ans;
        backtrack(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void backtrack(int start, int last, int[] nums) {
        if (start == nums.length) {
            if (temp.size() >= 2)
                ans.add(new ArrayList<>(temp));
            return;
        }

        if (nums[start] >= last) {
            temp.add(nums[start]);
            backtrack(start + 1, nums[start], nums);
            temp.remove(temp.size() - 1);
        }

        if (nums[start] != last)
            backtrack(start+1, last, nums);
    }

    public static void main(String[] args) {
        No491 t = new No491();
        int[] nums = {1,1,1,1};
        t.findSubsequences(nums);
        System.out.println(t.ans);
//        List<String> o = t.o;
//        HashSet<String> set = new HashSet<>(o);
//        System.out.println(o.size() + " " + set.size());
//        System.out.println((int)1e9+7);

    }

}
