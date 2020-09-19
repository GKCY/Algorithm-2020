package base;

import tool.Utils;

import java.util.Arrays;

public class No443 {
    public int compress(char[] chars) {
        if (chars.length == 0)
            return 0;
        char ch = chars[0];
        int count = 0;
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (ch == chars[i])
                count++;
            else if (ch != chars[i] && count == 1) {
                chars[idx++] = ch;
                ch = chars[i];
                count = 1;
            } else if (ch != chars[i] && count > 1) {
                chars[idx++] = ch;
                String nums = String.valueOf(count);
                for (char num : nums.toCharArray())
                    chars[idx++] = num;
                count = 1;
                ch = chars[i];
            }
        }
        chars[idx++] = ch;
        if (count > 1) {
            String nums = String.valueOf(count);
            for (char num : nums.toCharArray())
                chars[idx++] = num;
        }
        System.out.println(Arrays.toString(chars));
        return idx;
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new No443().compress(chars));
    }
}
