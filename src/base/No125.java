package base;

import java.util.ArrayList;

public class No125 {
    public boolean isPalindrome(String s) {

        ArrayList<Character> list = new ArrayList<>();
        for (char ch :
                s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                list.add(ch);
            else if (ch >= 'A' && ch <= 'Z') {
                int offset = ch - 'A';
                list.add((char) ('a' + offset));
            } else if (ch >= '0' && ch <= '9')
                list.add(ch);
        }
        if (list.size() == 0)
            return true;
        int i = 0, j = list.size();
        while (i < j) {
            if (list.get(i) != list.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
