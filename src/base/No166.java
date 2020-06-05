package base;

import java.util.HashMap;

public class No166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        long numeratorLong = numerator;
        long denominatorLong = denominator;

        StringBuilder builder = new StringBuilder();

        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            builder.append("-");
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);

        if (numeratorLong >= denominatorLong && numeratorLong % denominatorLong == 0)
            return  builder.toString() + String.valueOf(numeratorLong / denominatorLong);

        builder.append(numeratorLong / denominatorLong);
        builder.append('.');
        numeratorLong = (numeratorLong % denominatorLong) * 10;

        int count = builder.length();
        HashMap<Long, Integer> map = new HashMap<>();

        while (numeratorLong != 0) {
            if (map.containsKey(numeratorLong)) {
                builder.insert(map.get(numeratorLong), "(");
                builder.append(")");
                break;
            }
            map.put(numeratorLong, count);
            count++;
            long quotient = numeratorLong / denominatorLong;
            builder.append(quotient);
            numeratorLong = (numeratorLong % denominatorLong) * 10;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(No166.fractionToDecimal(Integer.MAX_VALUE, 37));
    }
}
