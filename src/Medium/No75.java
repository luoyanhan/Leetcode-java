package Medium;

public class No75 {
//    static class Solution {
//        public void sortColors(int[] nums) {
//            int low=0, high=nums.length-1;
//            partition(nums, low, high);
//        }
//        private static void partition(int[] nums, int low, int high){
//            if (low>high){
//                return;
//            }
//            int i = low, j = high;
//            int privot = nums[low];
//            while (i<j){
//                while (i<j && nums[j]>=privot){
//                    j--;
//                }
//                while (i<j && nums[i]<=privot){
//                    i++;
//                }
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//            }
//            nums[low] = nums[i];
//            nums[i] = privot;
//            partition(nums, low, i-1);
//            partition(nums, i+1, high);
//        }
//    }
    static class Solution {
        public void sortColors(int[] nums) {
            int zero=0, two=nums.length, i=0;
            while (i<two){
                if (nums[i]==0){
                    int tmp=nums[i];
                    nums[i]=nums[zero];
                    nums[zero]=tmp;
                    i++;
                    zero++;
                }else if (nums[i]==1){
                    i++;
                }else {
                    two--;
                    int tmp=nums[two];
                    nums[two]=nums[i];
                    nums[i]=tmp;
                }
            }
        }
    }
}
