package leetcodeInterview;

public class Mianshi64 {
    public int sumNums1(int n) {
        boolean flag = (n > 0) && (n += sumNums1(n-1)) > 0;
        return n;
    }

    public int sumNums2(int n) {
        return (int) (Math.pow(n,2) + n)>>1;
    }
}
