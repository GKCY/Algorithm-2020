package base;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;
import java.util.TreeMap;

public class No621 {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for (char ch : tasks)
            counter[ch-'A']++;
        Arrays.sort(counter);
        int length = counter[25];
        int sum = (length - 1) * (n + 1) + 1;
        int left = (length - 1 ) * n;

        int cur = 24;
        while (counter[cur] > 0) {
            if (counter[cur] == length) {
                left -= length - 1;
                sum++;
            } else
                left -= counter[cur];
            if (left < 0)
                return tasks.length;
            cur--;
        }
        return sum;
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new No621().leastInterval(chars, 0));
    }
}
