package competition;

public class No5399 {
    //todo 第26场双周赛 hard题
//    String res = "0";
//    public String largestNumber(int[] cost, int target) {
//        StringBuilder builder = new StringBuilder();
//        track(cost, target, builder);
//        return res;
//    }
//
//    public void track(int[] cost, int target, StringBuilder builder) {
//        if (target < 0)
//            return;
//        else if (target == 0) {
//            String str = builder.toString();
//            if (compare(str, res) > 0) {
//                res = str;
//            }
//
//        } else {
//
//            for (int i = 0; i < 9; i++) {
//                builder.append(i+1);
//                track(cost, target - cost[i], builder);
//                builder.deleteCharAt(builder.length()-1);
//            }
//        }
//    }

    public String largestNumber(int[] cost, int target) {
        String[][] dp = new String[10][target+1];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < target+1; j++) {
                if (i == 0) {
                    dp[i][j] = "0";
                } else if (j == 0){
                    dp[i][j] = "";
                } else {
                    String expression1 = dp[i-1][j];
                    String expression2 = j - cost[i-1] >= 0 ? dp[i][j-cost[i-1]] : "0";
                    if (expression1.equals("0") && expression2.equals("0"))
                        dp[i][j] = "0";
                    else if (expression1.equals("0"))
                        dp[i][j] = i + expression2;
                    else if (expression2.equals("0"))
                        dp[i][j] = expression1;
                    else
                        dp[i][j] = max(expression1, i + expression2);
                }
            }
        }
        return dp[9][target];
    }

    public String max(String s1, String s2) {
        if (s1.length() < s2.length())
            return s2;
        else if (s1.length() > s2.length())
            return s1;
        else if (s1.compareTo(s2) > 0)
            return s1;
        else
            return s2;

    }
    public static void main(String[] args) {
        int[] cost = {4,3,2,5,6,7,2,5,5};
        int target = 9;
        No5399 t = new No5399();
        System.out.println(t.largestNumber(cost, target));
    }
}
