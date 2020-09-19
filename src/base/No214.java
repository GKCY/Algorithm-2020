package base;

public class No214 {
    public String shortestPalindrome1(String s) {
        if (s.length() == 0)
            return s;
        String rs = new StringBuilder(s).reverse().toString();
        long hash1 = 0;
        long hash2 = 0;
        int max = 0;
        StringBuilder b = new StringBuilder();
        long pow = 1;
        for (int i = 0; i < s.length(); i++, pow *= 27) {
//            System.out.println("比较");
//            System.out.println(s.substring(0,i+1));
//            System.out.println(rs.substring(s.length()-i-1, s.length()));
            hash1 = (hash1 * 27 + (int)(s.charAt(i) - 'a' + 1) ) % 100000007;
//            b.insert(0, String.format("%d * 27^%d + ", rs.charAt(s.length()-i-1)-'a'+1, i));
            hash2 = (hash2 + (rs.charAt(s.length()-i-1)-'a'+1) * pow ) % 100000007;
            if (hash1 == hash2)
                max = i;
//            System.out.println(hash1 + " " + hash2);
//            System.out.println(hash(rs.substring(s.length()-i-1, s.length())));
//            System.out.println(b.toString());
        }
//        System.out.println(s.substring(0,max+1));
        StringBuilder builder = new StringBuilder();
        builder.append(rs.substring(0, s.length()-max-1));
        builder.append(s);
        return builder.toString();
    }

    public long hash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = 27 * hash + (int)(s.charAt(i)-'a'+1);
        }
        return hash;
    }

    public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        String rs = new StringBuilder(s).reverse().toString();
        for (int i = s.length(); i >= 0; i--) {
            String s1 = s.substring(0, i);
            String s2 = rs.substring(s.length() - i, s.length());
            if (s1.equals(s2)) {
                builder.append(new StringBuilder(s.substring(i, s.length()))
                        .reverse().toString());
                builder.append(s);
               break;
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(new No214().shortestPalindrome(s));
    }
}
