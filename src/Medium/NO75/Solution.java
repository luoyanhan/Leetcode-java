package Medium.NO75;

class Solution {
    public void sortColors(int[] nums) {
        int ptr0=0, ptr1=0, length=nums.length;
        for (int i=0; i<length; i++){
            if (nums[i]==1){
                int tmp = nums[i];
                nums[i] = nums[ptr1];
                nums[ptr1] = tmp;
                ptr1++;
            }else if (nums[i]==0){
                int tmp = nums[i];
                nums[i] = nums[ptr0];
                nums[ptr0] = tmp;
                if (ptr0<ptr1){
                    tmp = nums[i];
                    nums[i] = nums[ptr1];
                    nums[ptr1] = tmp;
                }
                ptr0++;
                ptr1++;
            }
        }
    }
}
