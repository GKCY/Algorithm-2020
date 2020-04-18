package competition;

import java.util.ArrayList;
import java.util.HashMap;

public class LCP07 {
    int res = 0;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public int numWays(int n, int[][] relation, int k) {
        for (int[] pair :
                relation) {
            if (!map.containsKey(pair[0]))
                map.put(pair[0], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
        }
        search(0, 0, k, n);
        return res;
    }

    public void search(int count, int num,int k, int n) {
        if (count == k) {
            if (num == n - 1)
                res++;
            return;
        }
        ArrayList<Integer> temp;
        if (map.containsKey(num))
            temp = map.get(num);
        else
            return;
        for (int start :
                temp) {
            search(count+1, start, k, n);
        }
    }

    public static void main(String[] args) {
        LCP07 t = new LCP07();
        int[][] num = {{0,2},{2,1}};
        int res = t.numWays(3, num, 2);
        System.out.println(res);
    }


}
