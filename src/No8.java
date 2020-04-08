public class No8 {

    public int myAtoi(String str) {
        boolean isNegtive = false;
        str = str.trim();
        if (str.length() == 0)
            return 0;
        if (str.charAt(0) == '-') {
            isNegtive = true;
            if (str.length() == 1)
                return 0;
            str = str.substring(1, str.length());
        }else if (str.charAt(0) == '+') {
            if (str.length() == 1)
                return 0;
            str = str.substring(1, str.length());
        }

        str = getNumber(str);
        if (str.length() == 0)
            return 0;

        int res = 0;
        if (isNegtive) {
            for (char ch : str.toCharArray()) {
                int number = ch - '0';
                if (res > Math.abs(Integer.MIN_VALUE/10) || res == Math.abs(Integer.MIN_VALUE/10)
                && number >= 8)
                    return Integer.MIN_VALUE;
                res = res * 10 + number;
            }

        } else {
            for (char ch : str.toCharArray()) {
                int number = ch - '0';
                if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && number >= 7))
                    return Integer.MAX_VALUE;
                res = res * 10 + number;
            }
        }

        return isNegtive ? -1 * res : res;
    }

    public String getNumber(String str) {
        int start = 0;
        while (true) {
            if (start <str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9')
                start++;
            else
                break;
        }
        return str.substring(0, start);
    }

    public static void main(String[] args) {
        No8 t = new No8();
        System.out.println(t.myAtoi("2147483648"));
//        System.out.println(t.getNumber("2147483648"));
    }
}
