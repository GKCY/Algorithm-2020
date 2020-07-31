package base;

import java.util.HashMap;

public class No397 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        if (map.containsKey(n))
            return map.get(n);
        int res, num = n + 1;
        if (n == 1)
            res = 0;
        else if (n % 2 == 0)
            res = integerReplacement(n/2) + 1;
        else{
            if (n == Integer.MAX_VALUE)
                res = Math.min(integerReplacement(n/2+1)+1, integerReplacement(n-1)) + 1;
            else
                res = Math.min(integerReplacement(num), integerReplacement(n-1)) + 1;

        }
        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No397().integerReplacement(7));
    }
}
