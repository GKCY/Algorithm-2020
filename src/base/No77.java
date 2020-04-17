package base;

import java.util.ArrayList;
import java.util.List;

public class No77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        trackback(1, n, k, temp, res);
        return res;
    }
    public void trackback(int start, int end, int k,
                          ArrayList<Integer> temp,  List<List<Integer>> res){
        if (temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= end; i++) {
            temp.add(i);
            trackback(i+1, end, k, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}





