import tool.Tools;

import java.util.Arrays;
import java.util.List;


public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        List<int[]> ints = Arrays.asList(nums);
        Tools.printArrays(ints.get(0));
    }


}



