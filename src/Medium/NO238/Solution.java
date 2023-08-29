package Medium.NO238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        R[len-1] = 1;
        for (int idx=1; idx<len; idx++){
            L[idx] = L[idx-1]*nums[idx-1];
        }
        for (int idx=len-2; idx>=0; idx--){
                R[idx] = R[idx+1]*nums[idx+1];
        }
        int[] res = new int[len];
        for (int idx=0; idx<len; idx++){
            res[idx] = L[idx]*R[idx];
        }
        return res;
    }
}
