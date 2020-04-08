import java.util.ArrayList;
import java.util.List;

public class No78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(Integer n : nums){
            int size = res.size();
            for(int i = 0; i < size; i++){
                ArrayList<Integer> tmp = new ArrayList<>(res.get(i));
                tmp.add(n);
                res.add(tmp);
            }
        }
        return res;
    }
}
