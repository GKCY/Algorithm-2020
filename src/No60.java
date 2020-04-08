import java.util.ArrayList;
import java.util.Stack;

public class No60 {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        ArrayList<Integer> factortials = getFactorial(n, k-1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int index :
                factortials) {
            stringBuilder.append(nums.get(index));
            nums.remove(index);
        }
        return stringBuilder.toString();
    }

    public ArrayList<Integer> getFactorial(int n, int k) {
         int[] factortials = new int[n];
         factortials[0] = 1;
        for (int i = 1; i < n; i++) {
            factortials[i] = i * factortials[i-1];
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = n-1; i >= 0 ; i--) {
            res.add(k / factortials[i]);
            k %= factortials[i];
        }
        return res;
    }


}
