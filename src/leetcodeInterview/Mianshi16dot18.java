package leetcodeInterview;

public class Mianshi16dot18 {
    public boolean patternMatching(String pattern, String value) {
        if (pattern.isEmpty())
            return value.isEmpty();
        if (pattern.length() == 1)
            return true;
        int countA = 0, countB = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a')
                countA++;
            else
                countB++;
        }

        int lengthA, lengthB;
        for (lengthA = 0; lengthA <= value.length(); ++lengthA) {
            int left = value.length() - lengthA * countA;
            if (lengthA == 0 && countB == 0)
                continue;
            if (countB == 0) {
                if (left != 0)
                    continue;
                else
                    lengthB = 0;
            } else {
                if (left < 0)
                    break;
                if (left % countB != 0)
                    continue;
                lengthB = left / countB;
            };
            String a = null, b = null;
            int ptr = 0;
            for (int i = 0; i < pattern.length() + 1; i++) {
                if (i == pattern.length()) {
                    if (a == null || b == null)
                        return true;
                    if (!a.equals(b))
                        return true;
                    break;
                }
                if (pattern.charAt(i) == 'a') {
                    String temp = value.substring(ptr, ptr + lengthA);
                    if (a == null)
                        a = temp;
                    else if (!temp.equals(a))
                        break;
                    ptr += lengthA;
                } else {
                    String temp = value.substring(ptr, ptr + lengthB);
                    if (b == null)
                        b = temp;
                    else if (!temp.equals(b))
                        break;
                    ptr += lengthB;
                }
            }
        }
        return false;
    }

    public boolean patternMatching1(String pattern, String value) {
        int count_a = 0, count_b = 0;
        for (char ch: pattern.toCharArray()) {
            if (ch == 'a') {
                ++count_a;
            } else {
                ++count_b;
            }
        }
        if (count_a < count_b) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        for (int len_a = 0; count_a * len_a <= value.length(); ++len_a) {
            int rest = value.length() - count_a * len_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = (count_b == 0 ? 0 : rest / count_b);
                int pos = 0;
                boolean correct = true;
                String value_a = "", value_b = "";
                for (char ch: pattern.toCharArray()) {
                    if (ch == 'a') {
                        String sub = value.substring(pos, pos + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_b;
                    }

                }
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Mianshi16dot18 t = new Mianshi16dot18();
        String p = "bbb";
        String s = "xxxxxx";
        System.out.println(t.patternMatching(p,s));
    }
}
