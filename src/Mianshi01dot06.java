public class Mianshi01dot06 {
    public String compressString(String S) {
        if (S.length() == 0)
            return "";
        StringBuilder res = new StringBuilder();
        char ch = S.charAt(0);
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ch)
                count++;
            else {
                res.append(String.valueOf(ch));
                res.append(String.valueOf(count));
                ch = S.charAt(i);
                count = 1;
            }
        }
        res.append(String.valueOf(ch));
        res.append(String.valueOf(count));
        String ans = res.toString();
        return ans.length() < S.length() ? ans : S;
    }
}
