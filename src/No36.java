
import java.util.HashSet;

public class No36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] row = new HashSet[9];
        HashSet<Integer>[] column = new HashSet[9];
        HashSet<Integer>[] subSudoku = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            subSudoku[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j])
                    continue;
                else {
                    int num = board[i][j] - '0';
                    if (row[i].contains(num))
                        return false;
                    else
                        row[i].add(num);
                    if (column[j].contains(num))
                        return false;
                    else
                        column[j].add(num);
                    int index = (i/3)*3+ j/3;
                    if (subSudoku[index].contains(num))
                        return false;
                    else
                        subSudoku[index].add(num);
                }

            }
        }
        return true;
    }
}
