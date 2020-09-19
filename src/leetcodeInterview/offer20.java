package leetcodeInterview;

import java.util.HashMap;

public class offer20 {
    public boolean isNumber(String s) {
        HashMap<Character, Integer>[] states = buildState();
        int state = 0;
        for (char ch: s.toCharArray()) {
            char alpha;
            if (ch == '+' || ch == '-')
                alpha = 's';
            else if (Character.isDigit(ch))
                alpha = 'n';
            else if (ch == '.')
                alpha = 'd';
            else if (ch == 'e' || ch == 'E')
                alpha = 'e';
            else if (ch == ' ')
                alpha = 'b';
            else
                alpha = '?';
            if (!states[state].containsKey(alpha))
                return false;
            state = states[state].get(alpha);
        }
        return state == 2 || state == 5 || state == 8
                || state == 9 || state == 3;
    }

    public HashMap<Character, Integer>[] buildState() {
        HashMap<Character, Integer>[] state = new HashMap[10];

        // n数字 s符号 b空格 d小数点 e就是e
        state[0] = new HashMap<>();
        state[0].put('n', 2);
        state[0].put('s', 1);
        state[0].put('b', 0);
        state[0].put('d', 4);

        state[1] = new HashMap<>();
        state[1].put('d', 4);
        state[1].put('n', 2);

        state[2] = new HashMap<>();
        state[2].put('n', 2);
        state[2].put('b', 9);
        state[2].put('e', 6);
        state[2].put('d', 3);

        state[3] = new HashMap<>();
        state[3].put('n', 5);
        state[3].put('b', 9);
        state[3].put('e', 6);

        state[4] = new HashMap<>();
        state[4].put('n', 5);

        state[5] = new HashMap<>();
        state[5].put('n', 5);
        state[5].put('b', 9);
        state[5].put('e', 6);

        state[6] = new HashMap<>();
        state[6].put('n', 8);
        state[6].put('s', 7);

        state[7] = new HashMap<>();
        state[7].put('n', 8);

        state[8] = new HashMap<>();
        state[8].put('n', 8);
        state[8].put('b', 9);

        state[9] = new HashMap<>();
        state[9].put('b', 9);

        return state;
    }




    public static void main(String[] args) {
        offer20 t = new offer20();
        String num = "46.e3";
        System.out.println(t.isNumber(num));
    }
}
