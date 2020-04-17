package base;

public class No29 {
    public int divide(int dividend, int divisor) {
        boolean isNegtive = false;
        if ((dividend < 0 && divisor > 0) ||(dividend > 0 && divisor < 0))
            isNegtive = true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int res = 0;
        while (dividend > divisor){
            res++;
            dividend -= divisor;
        }

        if (isNegtive)
            return -res;
        else
            return res;
    }
}
