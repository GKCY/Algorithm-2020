package base;

import java.util.ArrayList;
import java.util.List;

public class No89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            int length = res.size();
            for (int j = length - 1; j >= 0 ; j--) {
                int temp = res.get(j);
                res.add(temp | head);
            }
            head <<= 1;
        }
        return res;
    }
}
