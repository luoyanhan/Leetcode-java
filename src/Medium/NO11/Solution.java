package Medium.NO11;

class Solution {
    public int maxArea(int[] height) {
        int v = 0, left = 0, right = height.length-1;
        while (left<right){
            v = Math.max(v, (right-left)*Math.min(height[left], height[right]));
            if (height[left] <= height[right]){
                left += 1;
            }else {
                right -=1;
            }
        }
        return v;
    }
}
