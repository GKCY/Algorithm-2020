package base;

import java.util.Arrays;

public class No1371 {
    public static int findTheLongestSubstring(String s) {
        int res = 0;
        int[] map = new int[32];
        Arrays.fill(map, s.length());
        map[0] = -1;
        int status = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    status ^= 1;
                    break;
                case 'e':
                    status ^= 2;
                    break;
                case 'i':
                    status ^= 4;
                    break;
                case 'o':
                    status ^= 8;
                    break;
                case 'u':
                    status ^= 16;
                    break;
            }
            if (i > map[status])
                res = Math.max(res, i - map[status]);
            else
                map[status] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(No1371.findTheLongestSubstring("eleetminicoworoep"));
    }
}
