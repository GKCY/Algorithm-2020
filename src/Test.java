import java.lang.reflect.Array;
import java.util.*;

public class Test {


    public static void main(String[] args) {
       boolean[][] b = new boolean[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(b[i][j]);
            }
        }

    }

    static public void printArrays(int[] nums){
        StringBuilder res = new StringBuilder();
        res.append("{");
        for (int num :
                nums) {
            res.append(String.valueOf(num));
            res.append(',');
        }
        res.delete(res.length()-1, res.length());
        res.append('}');
        System.out.println(res.toString());
    }
}



