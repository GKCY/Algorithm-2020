package base;

import java.util.Random;

public class No470 {
    public int rand7 () {
        return new Random().nextInt(7) + 1;
    }

    public int rand10() {
        int a = rand7();
        int b = rand7();
        int rand = (a - 1) * 7 + b;
        if (rand <= 40)
            return (rand - 1) / 4 + 1;
        else
            return rand10();
    }

    public static void main(String[] args) {
        No470 t = new No470();
        System.out.println(t.rand10());
        System.out.println(t.rand10());
    }
}
