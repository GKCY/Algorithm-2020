package base;

public class No14 {
    public String solution1(String[] strs){
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() -1);
            if (prefix.length() == 0)
                return "";
        }
        return prefix;
    }
}
