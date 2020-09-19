import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;


public class Test {


    public static int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] == target)
                r = mid;
            else if (nums[mid] > target)
                r = mid;
            else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if (l == nums.length)
            return -1;
        return nums[r] == target ? r : -1;
    }

    public boolean R() {
        boolean[] flag = new boolean[1];
        P(flag);
        return flag[0];
    }

    public void P(boolean[] f) {
        f[0] = true;
    }

    
    public static void main(String[] args) throws IOException, BrokenBarrierException, InterruptedException {
//        CyclicBarrier barrier = new CyclicBarrier(3);
//        Executor executor = Executors.newFixedThreadPool(3);
//        executor.execute(new say("1", barrier));
//        executor.execute(new say("2", barrier));
//        executor.execute(new say("3", barrier));
//
//        executor.execute(new say("1", barrier));
////        executor.execute(new say("2", barrier));
//        executor.execute(new say("3", barrier));
//        System.out.println("123+".contains("2+"));

    }

    private static class say implements Runnable {

        String name;
        CyclicBarrier barrier;

        public say(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }


        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Hi, " + name);

        }
    }



}



