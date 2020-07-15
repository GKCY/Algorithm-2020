package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        res.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> last = res.get(res.size() - 1);
            for (int j = 0; j < last.size() - 1; j++) {
                temp.add(last.get(j) + last.get(j+1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}
