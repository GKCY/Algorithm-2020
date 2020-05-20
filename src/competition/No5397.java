package competition;

import java.util.ArrayList;
import java.util.List;

public class No5397 {
    public static List<String> simplifiedFractions(int n) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1)
                    res.add(j + "/" + i);
            }
        }
        return res;
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        System.out.println(No5397.simplifiedFractions(4));
    }
}
