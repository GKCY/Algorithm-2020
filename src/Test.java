import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> nums = new LinkedList<>();
        ArrayList<Integer> set = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(3);
//        List<Integer> res = nums.stream().filter(num -> num > 2).collect(Collectors.toList());
//        nums.stream().distinct().forEach();
        nums.stream().forEach(System.out::println);
        System.out.println(set);
    }


}



