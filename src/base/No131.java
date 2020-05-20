package base;

import tool.Tools;

import java.util.ArrayList;
import java.util.List;

public class No131 {

    boolean[][] dp;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s.length() == 0)
            return res;
        dp = new boolean[s.length()][s.length()];
        cal(s);
        backtrack(new ArrayList<String>(), 0, s);
        return res;
    }

    public void cal(String s) {
        for (int step = 0; step < s.length(); step++) {
            for (int i = 0; i < s.length() && i + step < s.length(); i++) {
                if (step == 0)
                    dp[i][i] = true;
                else if (step == 1) {
                    if (s.charAt(i) == s.charAt(i+1))
                        dp[i][i+1] = true;
                } else if (s.charAt(i) == s.charAt(i+step) && dp[i+1][i+step-1])
                    dp[i][i+step] = true;
            }
        }
    }

    public void backtrack(ArrayList<String> track, int start, String s){
        if (start == s.length()){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                track.add(s.substring(start, i+1));
                backtrack(track, i+1, s);
                track.remove(track.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        No131 t = new No131();
        t.partition("aba");
        Tools.printBooleanMatrix(t.dp);
    }
}
