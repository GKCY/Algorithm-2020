package base;

import java.util.*;

public class No386 {
    public List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return s1.compareTo(s2);
            }
        });
        return res;
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i <= 9; i++) {
//            dfs(i, res, n);
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            while (!stack.isEmpty()) {
                int num = stack.pop();
                if (num <= n) {
                    res.add(num);
                    for (int j = 9; j >= 0; j--) {
                        stack.push(num*10+j);
                    }
                }
            }
        }
        return res;
    }

//    private void dfs(int num, List<Integer> res, int n) {
//        if (num > n)
//            return;
//        res.add(num);
//        for (int i = 0; i <= 9; i++) {
//            dfs(num * 10 + i, res, n);
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new No386().lexicalOrder(13));
    }
}
