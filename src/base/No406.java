package base;

import tool.Utils;

import java.util.Arrays;
import java.util.LinkedList;

public class No406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] person: people)
            res.add(person[1], person);
        return res.toArray(new int[0][0]);

    }

    public static void main(String[] args) {
        int[][] people = {{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        No406 t = new No406();
        Utils.printTwoDimensionalArray(people);
        t.reconstructQueue(people);
    }
}
