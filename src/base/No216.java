package base;

import java.util.ArrayList;
import java.util.List;

public class No216 {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    int count;
    int target;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.count = k;
        this.target = n;
        search(1, 0, 0);
        return res;
    }

    public void search(int start, int count, int sum) {
        if (count == this.count) {
            if (sum == this.target)
                res.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                if (sum + i <= target)
                    search(i+1, count + 1, sum + i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
