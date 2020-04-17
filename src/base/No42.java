package base;

public class No42 {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                res += leftMax > height[left] ? leftMax - height[left] : 0;
                left++;
                leftMax = Integer.max(height[left-1], leftMax);
            } else if (leftMax > rightMax){
                res += rightMax > height[right] ? rightMax - height[right] : 0;
                right--;
                rightMax = Integer.max(height[right+1], rightMax);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] n = {0,1,0,2,1,0,1,3,2,1,2,1};
        No42 t = new No42();
        t.trap(n);

    }
}
