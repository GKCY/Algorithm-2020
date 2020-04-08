public class No43 {
    public String multiply(String num1, String num2) {
        int[] sum = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >= 0; i--){
            int n1 = num1.charAt(i)-'0';
            for (int j = num2.length()-1; j >= 0; j--){
                int n2 = num2.charAt(j)-'0';
                int temp = n1*n2 +sum[i+j+1];
                sum[i+j+1] = temp%10;
                sum[i+j] += temp/10;
            }
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (sum[i] == 0)
            i++;
        for (; i < sum.length; i++){
            builder.append(sum[i]);
        }
        return builder.toString();
    }
}
