package base;

import java.util.ArrayList;

public class No6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int row = Math.min(s.length(), numRows);
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i=0; i < row; i++)
            rows.add(new StringBuilder());
        int curRow = 0;
        Boolean goingDown = false;
        for (char c :
                s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows-1)
                goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder str :
                rows) {
            res.append(str);
        }

        return res.toString();
    }

}
