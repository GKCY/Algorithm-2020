package base;

public class No13 {
    public int romanToInt(String s) {
        int res = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            int value = romanCharacterToInt(s.charAt(i));
            if (i < size-1 && value < romanCharacterToInt(s.charAt(i+1)))
                res -= value;
            else
                res += value;
        }
        return res;
    }

    private int romanCharacterToInt(char ch){
        switch (ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
