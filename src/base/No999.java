package base;

public class No999 {
    static public int numRookCaptures(char[][] board) {
        int R_x = -1, R_y = -1, res = 0;
        int length = board.length;
        loop : for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'R'){
                    R_x = i;
                    R_y = j;
                    break loop;
                }
            }
        }
        int x = R_x-1, y = R_y;
        while (x >= 0 && board[x][y] != 'B') {
            if (board[x][y] == 'p') {
                res++;
                break;
            }
            x--;
        }
        x = R_x+1; y = R_y;
        while (x < length && board[x][y] != 'B') {
            if (board[x][y] == 'p') {
                res++;
                break;
            }
            x++;
        }
        x = R_x; y = R_y-1;
        while (y >= 0 && board[x][y] != 'B') {
            if (board[x][y] == 'p') {
                res++;
                break;
            }
            y--;
        }
        x = R_x; y = R_y+1;
        while (y < length && board[x][y] != 'B') {
            if (board[x][y] == 'p') {
                res++;
                break;
            }
            y++;
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(No999.numRookCaptures(board));
    }


//            ['.','.','.','.','.','.','.','.']
//            ['.','.','.','p','.','.','.','.']
//            ['.','.','.','p','.','.','.','.']
//            ['p','p','.','R','.','p','B','.']
//            ['.','.','.','.','.','.','.','.']
//            ['.','.','.','B','.','.','.','.']
//            ['.','.','.','p','.','.','.','.']
//            ['.','.','.','.','.','.','.','.']
}
