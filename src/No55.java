public class No55 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return false;
        boolean[] visited = new boolean[length];
        visited[length-1] = true;
        for (int i = length-2; i >= 0 ; i--) {
            for (int j = 1; j <= nums[i] && i+j < length; j++) {
                if (visited[i+j] == true) {
                    visited[i] = true;
                    break;
                }
            }
        }
        return visited[0];
    }

    public boolean canJump2(int[] nums) {
        int lastPos = nums.length-1;
        for (int i = nums.length-2; i >= 0; i--){
            if (nums[i] + i >= lastPos)
                lastPos = i;
        }
        return lastPos == 0;
    }
}
