package Medium;

public class No11 {
    class Solution {
        public int maxArea(int[] height) {
            int len = height.length;
            int left = 0, right = len-1, res = 0;
            while (left<right){
                int minHeight;
                int cur;
                if (height[left] <= height[right]){
                    minHeight = height[left];
                    cur = minHeight*(right-left);
                    left++;
                }else {
                    minHeight = height[right];
                    cur = minHeight*(right-left);
                    right--;
                }
                res = Math.max(cur, res);
            }
            return res;
        }
    }

    public static void main(String[] args){
        No11 outer = new No11();
        Solution inner = outer.new Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(inner.maxArea(height));
    }
}
