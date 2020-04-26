package base;

import java.util.Arrays;

public class No179 {
    public static String largestNumber(int[] nums) {

        StringBuilder builder = new StringBuilder();
        Arrays.stream(nums).boxed().map(String::valueOf)
                 .sorted((a, b) -> (a+b).compareTo(b+a))
                 .forEach(str -> builder.append(str));
        return builder.charAt(0) == '0' ? "0" : builder.toString();
    }

    public static String largestNumber2(int[] nums) {
        StringBuilder builder = new StringBuilder();
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (a, b) -> (b+a).compareTo(a+b));
        for (String str :
                strings) {
            builder.append(str);
        }
        return builder.charAt(0) == '0' ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        No179.largestNumber(new int[]{3, 30 , 34, 5, 9});
    }
}
