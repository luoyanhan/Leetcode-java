package Medium.NO287;

//class Solution {
//    public int findDuplicate(int[] nums) {
//        int len = nums.length;
//        int left = 1, right = len;
//        while (left<right){
//            int mid = (left+right)/2;
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
//        return left;
//    }
//}


//class Solution {
//    public int findDuplicate(int[] nums) {
//        int slow = 0, fast = 0;
//        do {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        }while (fast!=slow);
//        int ptr = 0;
//        while (ptr!=slow){
//            ptr = nums[ptr];
//            slow = nums[slow];
//        }
//        return slow;
//    }
//}


class Solution {
    public int findDuplicate(int[] nums) {
        int bitMax = 30;
        int res = 0;
        int len = nums.length, maxNum = len-1;
        while (bitMax>=0){
            int onePos = 1<<bitMax;
            if ((maxNum&onePos)!=0){
                break;
            }
            bitMax--;
        }
        for (int bitIdx=0; bitIdx<=bitMax; bitIdx++){
            int x = 0, y=0;
            int onePos = 1<<bitIdx;
            for (int idx=0; idx<len; idx++){
                if (idx>0 && (idx&onePos)!=0){
                    x++;
                }
                if ((nums[idx]&onePos)!=0){
                    y++;
                }
            }
            if (y>x){
                res = res|onePos;
            }
        }
        return res;
    }
}
