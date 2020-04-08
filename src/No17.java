import java.util.ArrayList;
import java.util.List;

public class No17 {
    static public List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        String[][] alphabet = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},
                {"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            int resultLength = result.size();
            if (resultLength == 0){
                for (String s :
                        alphabet[digit]) {
                    result.add(s);
                }
            } else {
                for (String s :
                        alphabet[digit]) {
                    for (int j = 0; j < resultLength; j++) {
                        result.add(result.get(j)+s);
                    }
                }
                result = result.subList(resultLength, result.size());
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(No17.letterCombinations1("23"));
    }
}
