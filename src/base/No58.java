package base;

import java.util.Arrays;

public class No58 {
    public static int lengthOfLastWord(String s) {
        String[] arr = s.trim().split("\\s+");
        return arr.length > 0 ? arr[arr.length-1].length() : 0;
    }

}
