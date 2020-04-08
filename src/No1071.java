public class No1071 {
    public String gcdOfStrings(String str1, String str2) {
        String s1 = str1+str2;
        String s2 = str2+str1;
        if(!s1.equals(s2))
            return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(a, b%a);
    }
}
