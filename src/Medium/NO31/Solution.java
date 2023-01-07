package Medium.NO31;

class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int idx1 = len-2;
        while (idx1>=0 && nums[idx1]>=nums[idx1+1]){
            idx1--;
        }
        if (idx1>=0){
            int idx2=len-1;
            while (idx2>=idx1 && nums[idx2]<=nums[idx1]){
                idx2--;
            }
            swap(nums, idx1, idx2);
        }
        reverse(nums, idx1+1);
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i){
        int j = nums.length-1;
        while (i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
