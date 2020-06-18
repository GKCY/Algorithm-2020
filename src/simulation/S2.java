package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class S2 {
    public String largestNumber(int[] nums) {
        ArrayList<String> arr = new ArrayList<>();
        Arrays.stream(nums).forEach(num -> arr.add(String.valueOf(num)));
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder buider = new StringBuilder();
        for (String str : arr) {
            buider.append(str);
        }
        String res = buider.toString();
        if (res.startsWith("0"))
            return "0";
        else
            return res;
    }
}
