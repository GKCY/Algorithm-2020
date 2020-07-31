package ProgrammingPearls.chapter1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

public class NumsGenarator {
    static void genarator() throws IOException {
        final int size = 1000000;
        Random rand = new Random();
        HashSet set = new HashSet();
        File writeName = new File("src/ProgrammingPearls/chapter1/nums.txt");
        writeName.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(writeName));
        while (set.size() < 1000000) {
            int num = rand.nextInt(10000000) + 1;
            if (!set.contains(num)) {
                set.add(num);
                writer.write(String.valueOf(num) + "\r\n");
            }
        }
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) {
        try {
            NumsGenarator.genarator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
