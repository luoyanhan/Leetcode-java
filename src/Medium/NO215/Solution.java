package Medium.NO215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }

    public int quickSelect(int[] nums, int left, int right, int index){
        int tarIndex = partition(nums, left, right);
        if (tarIndex==index){
            return nums[tarIndex];
        }
        if (tarIndex<index){
            return quickSelect(nums, tarIndex+1, right, index);
        }else {
            return quickSelect(nums, left, tarIndex-1, index);
        }
    }

    public int partition(int[] nums, int left, int right){
        int tar = nums[right];
        int slow = left-1;
        for (int fast=left; fast<right; fast++){
            if (nums[fast]<=tar){
                slow++;
                swap(nums, fast, slow);
            }
        }
        swap(nums, slow+1, right);
        return slow+1;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
