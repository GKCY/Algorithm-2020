package base;

import java.util.ArrayList;

public class No679 {
    final double EPSILON = 1e-6;
    final int ADD = 0, SUB = 1, DIV = 2, MUL = 3;
    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> nextNums = new ArrayList<>();
        for (int num : nums) {
            nextNums.add((double)num);
        }
        return search(nextNums);
    }

    public boolean search(ArrayList<Double> nums) {
        if (nums.size() == 0) {
            return false;
        }
        if (nums.size() == 1) {
            return Math.abs(24.0 - nums.get(0)) < EPSILON;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    double a = nums.get(i);
                    double b = nums.get(j);
                    ArrayList<Double> nextNums = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j)
                            nextNums.add(nums.get(k));
                    }

                    for (int k = 0; k < 4; k++) {
                        if (k == ADD)
                            nextNums.add(a + b);
                        else if (k == SUB)
                            nextNums.add(a - b);
                        else if (k == MUL)
                            nextNums.add(a * b);
                        else if (k == DIV) {
                            if (b == 0)
                                continue;
                            else
                                nextNums.add(a / b);
                        }
                        if (search(nextNums))
                            return true;
                        nextNums.remove(nextNums.size()-1);
                    }
                }
            }
        }
        return false;
    }
}
