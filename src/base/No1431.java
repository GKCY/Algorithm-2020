package base;

import java.util.ArrayList;
import java.util.List;

public class No1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candie :
                candies) {
            max = Math.max(max, candie);
        }

        List<Boolean> res = new ArrayList<>();
        for (int candie :
                candies) {
            if (candie + extraCandies >= max)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}
