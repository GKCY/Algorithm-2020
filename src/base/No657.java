package base;

public class No657 {
    public boolean judgeCircle(String moves) {
        int up = 0, left = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R':
                    left--;
                    break;
                case 'L':
                    left++;
                    break;
                case 'U':
                    up++;
                    break;
                case 'D':
                    up--;
                    break;
            }
        }
        return up == 0 && left == 0;
    }
}
