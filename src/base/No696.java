package base;

import java.util.ArrayList;

public class No696 {
    public int countBinarySubstrings(String s) {
        if (s.length() == 0)
            return 0;
        ArrayList<Integer> nums = new ArrayList<>();
        int cur = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            if (num == cur)
                count++;
            else if (num != cur) {
                if (count != 0)
                    nums.add(count);
                count = 1;
                cur = num;
            }
        }
        nums.add(count);
        int res = 0;
        for (int i = 1; i < nums.size(); i++) {
            res += Math.min(nums.get(i-1), nums.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "10101";
        System.out.println(new No696().countBinarySubstrings(s));
    }
}
