public class No5 {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        int left=0, right=0, max=1;

        int l = s.length();
        boolean[][] P = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            P[i][i] = true;
        }
        for (int i = 0; i+1 < l; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                P[i][i + 1] = true;
                if (max < 2){
                    left = i;
                    right = i+1;
                    max = 2;
                }
            }
        }

        int step = 2;
        while (step < l){
            for (int i = 0; i+step < l; i++) {
                if (P[i+1][i+step-1] == true && s.charAt(i) == s.charAt(i+step)) {
                    P[i][i + step] = true;
                    if (step+1 > max){
                        left = i;
                        right = i+step;
                        max = step+1;
                    }
                } else {
                    P[i][i + step] = false;
                }
            }
            step++;
        }
        return s.substring(left, right+1);
    }

    public String solution(String s) {
        if (s.length() == 0)
            return "";
        int max = 0;
        int start = 0, end = 0;
        int length = s.length();
        boolean[] P = new boolean[length*2-1];
        for (int l = 1; l < length; l++) {
            for (int i = 0; i < length; i++){
                int j = i+l;
                if (j >= length)
                    break;
                if (s.charAt(i) == s.charAt(j) && (j-i<3 || P[i+j])){
                    P[i+j] = true;
                    if (j-i+1 > max){
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                } else
                    P[i+j] = false;
            }
        }
        return s.substring(start, end+1);

    }

    public String longestPalindrome7(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

}
