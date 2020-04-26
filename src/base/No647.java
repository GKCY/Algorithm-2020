package base;

import tool.Tools;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Arrays;

public class No647 {
    public static int countSubstrings(String s) {
        int res = 0;
        boolean[] dp = new boolean[s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = s.length()-1; j >= i; j--) {
                if (i == j) {
                    dp[j] = true;
                    res++;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[j] = true;
                    res++;
                } else if (j - i > 1 && s.charAt(i) == s.charAt(j) && dp[j-1]) {
                    dp[j] = true;
                    res++;
                } else {
                    dp[j] = false;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(No647.countSubstrings("abc"));
    }
}
