package Medium.NO287;

//class Solution {
//    public int findDuplicate(int[] nums) {
//        int len = nums.length;
//        int left = 0, right = len;
//        while (left<right){
//            int mid = left + (right-left)/2;
//            int cnt = 0;
//            for (int num:nums){
//                if (num<=mid){
//                    cnt++;
//                }
//            }
//            if (cnt<=mid){
//                left = mid+1;
//            }else {
//                right = mid;
//            }
//        }
//        return right;
//    }
//}


class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (fast!=slow);
        int ptr = 0;
        while (ptr!=slow){
            ptr = nums[ptr];
            slow = nums[slow];
        }
        return slow;
    }
}
