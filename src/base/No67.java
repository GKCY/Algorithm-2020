package base;

public class No67 {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0, bitSum;
        while (i >= 0 || j >= 0) {
            int aBit = i >= 0 ? a.charAt(i) - '0' : 0;
            int bBit = j >= 0 ? b.charAt(j) - '0' : 0;
            bitSum = aBit + bBit + carry;
            carry = bitSum / 2;
            builder.append(bitSum % 2);
            i--;
            j--;
        }
        if (carry == 1)
            builder.append(1);
        return builder.reverse().toString();
    }
}
