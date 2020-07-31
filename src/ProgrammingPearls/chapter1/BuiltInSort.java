package ProgrammingPearls.chapter1;

import java.io.*;
import java.util.ArrayList;

public class BuiltInSort {
    static void sort() throws IOException {
        ArrayList<Integer> nums = new ArrayList<>(1000000);

        String readPath = "src/ProgrammingPearls/chapter1/nums.txt";
        File file = new File(readPath);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null) {
            nums.add(Integer.valueOf(line));
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        nums.sort((a, b) -> a - b);


        File writeName = new File("src/ProgrammingPearls/chapter1/builtIn.txt");
        writeName.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(writeName));
        for (int num : nums) {
            writer.write(String.valueOf(num) + "\r\n");
        }
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) {
        try {
            BuiltInSort.sort();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
