package competition;

import java.util.ArrayList;

public class No5519 {
    public String reorderSpaces(String text) {
        StringBuilder word = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();
        int count = 0;

        for (char ch :
                text.toCharArray()) {
            if (ch == ' ') {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word = new StringBuilder();
                }
                count++;
            } else if (ch != ' '){
                word.append(ch);
            }
        }
        if (word.length() > 0)
            words.add(word.toString());

        int delimiter;
        if (words.size() <= 1)
            delimiter = 0;
        else
            delimiter = count / (words.size() - 1);
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < delimiter; i++) {
            space.append(" ");
        }
        StringBuilder res = new StringBuilder();
        res.append(String.join(space, words));
//        System.out.println(res.toString());
        if (delimiter * (words.size() - 1) != count) {
            int i = count - delimiter * (words.size() - 1);
            while (i-- > 0)
                res.append(" ");
        }
//        System.out.println(words.size());
//        System.out.println(words);
//        System.out.println(count);
//        System.out.println(delimiter);
        return res.toString();
    }

    public static void main(String[] args) {
        String str = " practice   makes   perfect";
        System.out.println(new No5519().reorderSpaces(str));
    }
}
