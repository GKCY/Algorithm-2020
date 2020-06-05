package base;

import java.util.ArrayList;
import java.util.List;

public class No78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(Integer n : nums){
            System.out.println(res);
            int size = res.size();
            for(int i = 0; i < size; i++){
                ArrayList<Integer> tmp = new ArrayList<>(res.get(i));
                tmp.add(n);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No78().subsets(new int[]{1,2,3}));
    }
}
